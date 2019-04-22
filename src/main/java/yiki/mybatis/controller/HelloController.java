package yiki.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.bean.Data;
import yiki.mybatis.bean.Firm;
import yiki.mybatis.bean.Resume;
import yiki.mybatis.bean.User;
import yiki.mybatis.mapper.FirmMapper;
import yiki.mybatis.mapper.ResumeMapper;
import yiki.mybatis.mapper.UserMapper;
import yiki.mybatis.mapper.UserYmlMapper;
import yiki.mybatis.util.JsonUtil;

import java.util.ArrayList;
import java.util.Map;


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



    @PostMapping("/test")
    public int test(@RequestBody Map<String, Object> models) {
        Map<String, Object> userobj = (Map<String, Object>) models.get("user");
        ArrayList<Map<String, Object>> test = (ArrayList<Map<String, Object>>) models.get("test");


        try {
            User user = JsonUtil.map2obj(userobj, User.class);

            for (Map<String, Object> item : test) {
                Data data = JsonUtil.map2obj(item, Data.class);
                System.out.println(data);
                System.out.println(data.getB());
            }

            System.out.println(user.getUname());
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }

}
