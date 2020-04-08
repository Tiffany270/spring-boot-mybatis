package yiki.mybatis.react_app_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.mapper.UserMapper_react;
import yiki.mybatis.react_app_bean.UserSchema;
import yiki.mybatis.react_app_util.Result;

@ResponseBody
@RestController
@RequestMapping("/react")
public class UserController {

    @Autowired
    private UserMapper_react userMapper_react;

    @PostMapping("/register")
    public Result register(@RequestBody UserSchema user) {
        try{
            int result = userMapper_react.insertUser(user);
            if(result==1){
                return Result.ok(user);
            }else{
                return  Result.error(500,"注册失败");
            }
        }catch (DataAccessException e){
            return  Result.error(500,"数据库异常:  "+e.getCause());
        }
    }

    @GetMapping("/test")
    public Result test() {
        UserSchema user = new UserSchema("test2",
                "12345",
                "0",
                null
        );
        try{
            int result = userMapper_react.insertUser(user);
            System.out.println(result);
            if(result==1){
                return Result.ok(user);
            }else{
                return  Result.error(500,"注册失败");
            }
        }catch (DataAccessException e){
            return  Result.error(500,"数据库异常:  "+e.getCause());
        }

    }


}
