package com.example.controller;

import com.example.model.ItemTable;
import com.example.model.UserTable;
import com.example.services.ItemServices;
import com.example.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DemoController
{
//    @ResponseBody
    @Autowired
    UserServices userServices;
    @Autowired
    ItemServices itemServices;
    UserTable userTable;
    ItemTable itemTable;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String Demo()
    {
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String submit(ModelMap modelmap, @RequestParam String uname, @RequestParam String upass, @RequestParam String role, HttpServletResponse response)
    {
        String msg="Please provide the correct username and password";

        userTable=new UserTable();
        itemTable=new ItemTable();
        userTable=userServices.getUserByName(uname);
        String dbUserName=userTable.getName();
        String dbPassword=userTable.getPassword();
        String dbEmail=userTable.getEmail();
        String dbRole=userTable.getRole();
        if(userTable==null || !(dbUserName.equals(uname) && dbPassword.equals(upass)) || !dbRole.equals(role))
        {
            modelmap.put("errorMsg",msg);
            return "login";
        }
        modelmap.put("User_Name",uname.toUpperCase().charAt(0));
        modelmap.put("User_Email",dbEmail);
        Cookie cookie = new Cookie("username", uname);
        response.addCookie(cookie);
        if(dbRole.equals("admin"))
        {
            List<ItemTable> items=itemServices.getAllItems();
            System.out.println(items.size());
            modelmap.put("itemlist",items);

            return "admin";
        }
        return "view";
    }

    @RequestMapping(value="/admin",method = RequestMethod.GET)
    public String adminView(ModelMap modelmap)
    {
        userTable=new UserTable();
        userTable=userServices.getUserByName("admin");
        String dbUserName=userTable.getName();
        String dbEmail=userTable.getEmail();
        modelmap.put("User_Name",dbUserName);
        modelmap.put("User_Email",dbEmail);
        List<ItemTable> items=itemServices.getAllItems();
        modelmap.put("itemlist",items);

        return "admin";
    }

    @RequestMapping(value="/view",method = RequestMethod.GET)
    public String view(ModelMap model,@CookieValue(value = "username") String username)
    {
        userTable=new UserTable();
        userTable=userServices.getUserByName(username);
        String dbUserName=userTable.getName();
        String dbEmail=userTable.getEmail();
        model.put("User_Name",(dbUserName.toUpperCase().charAt(0)));
        model.put("User_Email",dbEmail);
        return "view";
    }

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String registerPage()
    {
        return "register";
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(ModelMap modelmap,@RequestParam String uname,@RequestParam String uemail,@RequestParam String upass)
    {
        modelmap.put("User_Name",uname);
        modelmap.put("User_Email",uemail);
        userServices.addUser(uname,uemail,upass,"user");
        return "login";
    }

    @RequestMapping(value="/additem",method = RequestMethod.GET)
    public String addItem()
    {
        return "additem";
    }

    @RequestMapping(value="/additem",method = RequestMethod.POST)
    public String saveItem(@RequestParam String uid,@RequestParam String iname,@RequestParam String isource,@RequestParam String idestination,@RequestParam String iestimateddate) throws NoSuchAlgorithmException, ParseException {
        itemTable=new ItemTable();
        String tracking_id=itemTable.generateTrackingId();
        Date date =new Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date estimated = (Date)formatter.parse(iestimateddate);
        System.out.println(date+" "+estimated+" "+tracking_id);
        String location=isource;
        itemServices.addUser(iname,tracking_id,isource,idestination,location,date,estimated,uid);
        return "redirect:/admin";
    }

    @RequestMapping(value="/trackitem",method = RequestMethod.POST)
    public String trackItem(ModelMap model,@RequestParam String trackid,@CookieValue(value = "username") String username)
    {
        userTable=new UserTable();
        userTable=userServices.getUserByName(username);
        String dbUserName=userTable.getName();
        String dbEmail=userTable.getEmail();
        model.put("User_Name",(dbUserName.toUpperCase().charAt(0)));
        model.put("User_Email",dbEmail);
        itemTable=new ItemTable();
        itemTable=itemServices.getItemByTrackId(trackid);
        if(itemTable.getUserName().equals(username))
        {
            model.put("itemName","Item Name : "+itemTable.getName());
            model.put("source","Order Received at "+itemTable.getSource());
            if(itemTable.getSource().equals(itemTable.getLocation()))
            {
                model.put("location","Yet to dispatch");
            }
            else
            {
                model.put("location","Item arrived at "+itemTable.getLocation());
            }
            System.out.println(itemTable.getDestination());
            System.out.println(itemTable.getLocation());
            if(itemTable.getDestination().equals(itemTable.getLocation()))
            {
                model.put("destination","Item reached the destination at "+itemTable.getDestination());
            }
            else
            {
                model.put("destination","Yet to arrive the destination at "+itemTable.getDestination());
            }
            model.put("orderDate","Order Received on "+itemTable.getOrderDate());
            model.put("estimatedDate","Expect Delivery within "+itemTable.getEstimatedDate());
            model.put("error","");
        }
        else
        {
            model.put("error","Enter correct input");
        }
        return "view";
    }

    @RequestMapping(value="/edititem",method = RequestMethod.GET)
    public String editItem()
    {
        return "edititem";
    }

    @RequestMapping(value="/edititem",method = RequestMethod.POST)
    public String updateItem(@RequestParam String trackid,@RequestParam String location)
    {
        itemServices.updateItem(trackid,location);
        return "redirect:/admin";
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout()
    {
        return "login";
    }

}