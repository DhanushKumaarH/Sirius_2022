package com.example.services;

import com.example.model.UserTable;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices
{
    @Autowired
    private UserRepository userRepository;

    public List<UserTable> getAllUsers()
    {
        return userRepository.findAllByJQL();
    }

    public UserTable getUserByName(String userName)
    {
        return userRepository.findByUserNameByJql(userName);
    }

    public String addUser(String uname,String uemail,String upass,String role)
    {
        userRepository.saveByJQL(uname,uemail,upass,role);
        return "Registeration Successfull";
    }
}