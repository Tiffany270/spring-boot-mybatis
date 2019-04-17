package yiki.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.bean.User;
import yiki.mybatis.mapper.UserMapper;
import yiki.mybatis.mapper.UserYmlMapper;


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

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userMapper.getUserById(id);
    }

    @GetMapping("/userxml/{uid}")
    public User getxmlUser(@PathVariable("uid") Integer id) {
        return userYmlMapper.getUserById(id);
    }
     /*
    *
    * GET	    /books	获取列表
      POST	    /book	创建一本书
      GET	    /books/id	通过id查询一本书列表
      PUT	    /book/id	通过id更新一本书
      DELETE	/book/id	通过id删除一本书*/

    @PostMapping("/user")
    public boolean addUser() {
        return userYmlMapper.insertUser(new User("tiffany", "1111", "dddd"));
    }

//    @PostMapping(value = "login")
//    public void login(String name, @RequestParam String password) {
//        System.out.println(name + ":" + password);
//    }

}
