package yiki.mybatis.controller.auth;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.Service.UserService;
import yiki.mybatis.bean.User;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
//    @PostMapping(value = "login")
//    public void login(String name, @RequestParam String password) {
//        System.out.println(name + ":" + password);
//    }


    /*
    * x/user/1 GET  根据用户id查询用户数据
      x/user   POST 新增用户
      x/user   PUT 修改用户信息
      x/user   DELETE 删除用户信息*/

    @PostMapping("/user")
    public int registeUser(@RequestBody User user) {
        boolean res = userService.addUser(user);
        if (res) {
            return 1;
        }
        return 0;
    }


    @PostMapping("/authUser")
    public User authUser(@RequestBody User user) {
        System.out.println(user.getUname());
        User res = userService.authUser(user.getUname(), user.getUpassword());
        if (res != null) {
            return user;
        }
        return null;
    }


}
