package com.example.services;

import com.example.model.ItemTable;
import com.example.model.UserTable;
import com.example.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServices
{
    @Autowired
    private ItemRepository itemRepository;

    public List<ItemTable> getAllItems()
    {
        return itemRepository.findAllByJQL();
    }

    public ItemTable getItemByTrackId(String trackid)
    {
        return itemRepository.findByTrackidByJql(trackid);
    }

    public String addUser(String iname, String tracking_id, String source, String destination, String location, Date orderDate,Date estimatedDate,String user_id)
    {
        itemRepository.saveByJQL(iname,tracking_id,source,destination,location,orderDate,estimatedDate,user_id);
        return "Item Added Successfully";
    }

    public String updateItem(String trackid,String location)
    {
        itemRepository.updateLocationByTrackId(trackid,location);
        return "Update Successfull";
    }
}
