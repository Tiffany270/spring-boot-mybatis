package yiki.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.Service.FirmService;
import yiki.mybatis.Service.UserService;
import yiki.mybatis.bean.Firm;
import yiki.mybatis.bean.User;
import yiki.mybatis.mapper.AutoMapper;
import yiki.mybatis.mapper.UserMapper;

import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private FirmService firmService;
    @Autowired
    private  UserMapper userMapper;

    @Autowired
    private AutoMapper autoMapper;


    @GetMapping("/AllUser")
    public List<Map> getAllUser(){
        return userMapper.getAllUser();
    }


    @GetMapping("/AllFirm")
    public List<Map> getAllFirm(){
        return autoMapper.getAllfirm();
    }

    @GetMapping("/deletUser/{uid}")
    public int deletUser(@PathVariable("uid") Integer uid){
        return userMapper.deleteUserById(uid);
    }

    @DeleteMapping("/deletFirm/{cid}")
    public int deletFirm(@PathVariable("cid") Integer cid){
        return autoMapper.deleteFirmById(cid);
    }



}
