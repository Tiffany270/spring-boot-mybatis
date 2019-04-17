package yiki.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @PostMapping(value = "/auth/login")
    @ResponseBody//返回JSON，毕竟我已经不用视图了
    //@RequestParam标注后如果为空，会报错
    public String login(@RequestParam("username")
                                String username,
                        @RequestParam("password")
                                String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return "1";
        }
        return "0";
    }
}
