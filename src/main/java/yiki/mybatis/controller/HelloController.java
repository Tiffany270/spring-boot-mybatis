package yiki.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.bean.Firm;
import yiki.mybatis.bean.User;
import yiki.mybatis.mapper.FirmMapper;
import yiki.mybatis.mapper.UserMapper;
import yiki.mybatis.mapper.UserYmlMapper;


/*
 * 测试用
 * */

@ResponseBody
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserYmlMapper userYmlMapper;
    @Autowired
    FirmMapper firmMapper;


    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userMapper.getUserById(id);
    }

    @GetMapping("/userxml/{uid}")
    public User getxmlUser(@PathVariable("uid") Integer id) {
        return userYmlMapper.getUserById(id);
    }

    @GetMapping("/firmtest/{cid}")
    public Firm getfirm(@PathVariable("cid") Integer cid) {
        return firmMapper.getFirmById(cid);
    }
}
