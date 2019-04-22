package yiki.mybatis.controller.auth;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.Service.FirmService;
import yiki.mybatis.Service.UserService;
import yiki.mybatis.bean.Firm;
import yiki.mybatis.bean.User;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private FirmService firmService;

//    @PostMapping(value = "login")
//    public void login(String name, @RequestParam String password) {
//        System.out.println(name + ":" + password);
//    }


    /*
    * x/user/1 GET  根据用户id查询用户数据
      x/user   POST 新增用户
      x/user   PUT 修改用户信息
      x/user   DELETE 删除用户信息*/


    @PostMapping("/authUser")
    public User authUser(@RequestBody User user) {
        System.out.println(user.getUname());
        User res = userService.authUser(user.getUname(), user.getUpassword());
        if (res != null) {
            return user;
        }
        return null;
    }

    @PostMapping("/authFirm")
    public Firm authFirm(@RequestBody Firm firm) {
        Firm res = firmService.authFirm(firm.getCname(), firm.getCpassword());
        if (res != null) {
            return res;
        }
        return null;
    }


}
