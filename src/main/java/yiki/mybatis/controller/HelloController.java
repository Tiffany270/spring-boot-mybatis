package yiki.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.bean.Firm;
import yiki.mybatis.bean.Resume;
import yiki.mybatis.bean.User;
import yiki.mybatis.mapper.FirmMapper;
import yiki.mybatis.mapper.ResumeMapper;
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

    @Autowired
    ResumeMapper resumeMapper;


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

    @PostMapping("/resume")
    public int postresume(@RequestBody Resume resume) {
        System.out.println(resume);
        if (resumeMapper.insertResume(resume)) {
            return 1;
        }
        return 0;
    }
}
