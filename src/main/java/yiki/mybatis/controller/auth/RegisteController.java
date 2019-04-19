package yiki.mybatis.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yiki.mybatis.Service.FirmService;
import yiki.mybatis.Service.UserService;
import yiki.mybatis.bean.Firm;
import yiki.mybatis.bean.User;

@RestController
public class RegisteController {

    @Autowired
    private UserService userService;

    @Autowired
    private FirmService firmService;


    //注册用户（求职）
    @PostMapping("/user")
    public int registeUser(@RequestBody User user) {
        boolean res = userService.addUser(user);
        if (res) {
            return 1;
        }
        return 0;
    }

    //注册公司
    @PostMapping("/firm")
    public int registeFirm(@RequestBody Firm firm) {
        System.out.println(firm.getCname());
        boolean res = firmService.addFirm(firm);
        if (res) {
            return 1;
        }
        return 0;
    }



}
