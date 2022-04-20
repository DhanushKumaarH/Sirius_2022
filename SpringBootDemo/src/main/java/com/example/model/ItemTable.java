package com.example.model;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

@Entity
@Table
public class ItemTable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tracking_id;
    private String name;
    private String userName;
    private String source;

    private String destination;
    private String location;
    private Date orderDate;
    private Date estimatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTracking_id() {
        return tracking_id;
    }

    public void setTracking_id(String tracking_id) {
        this.tracking_id = tracking_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(Date estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public String generateTrackingId() throws NoSuchAlgorithmException
    {
        SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
        String randomNum = Integer.valueOf(prng.nextInt()).toString();
        MessageDigest sha=MessageDigest.getInstance("SHA-1");
        byte[] result=sha.digest(randomNum.getBytes());
        return hexEncode(result);
//        UUID idOne = UUID.randomUUID();
//        String value=String.valueOf(idOne);
//        String arr[]=value.split("-");
//        String token="";
//        for(String i :arr)
//        {
//            token+=i;
//        }
//        return token;
    }
    static private String hexEncode(byte[] input){
        StringBuilder result = new StringBuilder();
        char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
        for (int idx = 0; idx < input.length; ++idx)
        {
            byte b = input[idx];
            result.append(digits[ (b&0xf0) >> 4 ]);
            result.append(digits[ b&0x0f]);
        }
        System.out.println("track="+result.toString());
        return result.toString();
   }
}