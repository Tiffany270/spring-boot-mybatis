package yiki.mybatis.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/user")
    public int registeUser(@RequestBody User user) {
        boolean res = userService.addUser(user);
        if (res) {
            return 1;
        }
        return 0;
    }

}
