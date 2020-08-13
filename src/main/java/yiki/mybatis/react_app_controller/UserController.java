package yiki.mybatis.react_app_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.mapper.UserMapper_react;
import yiki.mybatis.react_app_bean.UserSchema;
import yiki.mybatis.react_app_util.Result;
import yiki.mybatis.react_app_util.UserTool;

import java.util.List;

@ResponseBody
@RestController
@RequestMapping("/react")
public class UserController {

    @Autowired
    private UserMapper_react userMapper_react;

    @PostMapping("/register")
    public Result register(@RequestBody UserSchema user) {
        try {

            String name = user.getUsername();
            UserSchema tempuser = userMapper_react.getUserByName(name);
            if (tempuser != null) {
                return Result.error(501, "已存在该用户名");
            } else {
                user.setUserid(UserTool.setUserid(user.getUserid()));
                user.setUserpsw(UserTool.setUserpsw(user.getUserpsw()));
                int result = userMapper_react.insertUser(user);
                if (result == 1) {
                    return Result.ok(user);
                } else {
                    return Result.error(500, "注册失败");
                }
            }
        } catch (DataAccessException e) {
            return Result.error(500, "数据库异常:  " + e.getCause());
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserSchema user) {
        String name = user.getUsername();
        String psw = UserTool.setUserpsw(user.getUserpsw());
        try {
            UserSchema res = userMapper_react.getUserByNameAndPassword(name, psw);
            if (res != null) {
                return Result.ok(res);
            } else {
                return Result.error(500, "密码不匹配");
            }
        } catch (DataAccessException e) {
            return Result.error(500, "数据库异常:  " + e.getCause());
        }
    }


    @PostMapping("/updataInfo")
    public Result updataInfo(@RequestBody UserSchema user) {
        try {
            int res = userMapper_react.updateUser(user);
            if (res == 1) {
                return Result.ok(user);
            } else {
                return Result.error(500, "更新失败");
            }
        } catch (DataAccessException e) {
            return Result.error(500, "数据库异常:  " + e.getCause());
        }
    }


    @GetMapping("/userList")
    public Result getAllUserList() {

        try {
            List<UserSchema> list = userMapper_react.getAllUserList();
            if (list != null) {
                return Result.ok(list);
            } else {
                return Result.error(500, "查询失败");
            }

        } catch (DataAccessException e) {
            return Result.error(500, "数据库异常:  " + e.getCause());

        }
    }


    @GetMapping("/userList/{type}")
    public Result getAllUserListByType(@PathVariable("type") int usertype) {
        String userType = "招聘";
        if (usertype == 1) {
            userType = "招聘";
        } else {
            userType = "应聘";
        }
        try {
            List<UserSchema> list = userMapper_react.getAllUserListByType(userType);
            if (list != null) {
                return Result.ok(list);
            } else {
                return Result.error(500, "查询失败");
            }

        } catch (DataAccessException e) {
            return Result.error(500, "数据库异常:  " + e.getCause());

        }
    }


    // Chat 获取信息列表/存数据库，和即时通信无关？
    @GetMapping("/msgList/{id}")
    public Result getMsgListByid(@PathVariable("id") int id) {

        return null;

    }

    @PostMapping("/test")
    public Result test(@RequestBody UserSchema user) {
//        UserSchema user = new UserSchema(
//                "test2",
//                "12345",
//                "0",
//                null
//        );
        System.out.println(user);
        try {
            int result = userMapper_react.insertUser(user);
            System.out.println(result);
            if (result == 1) {
                return Result.ok(user);
            } else {
                return Result.error(500, "注册失败");
            }
        } catch (DataAccessException e) {
            return Result.error(500, "数据库异常:  " + e.getCause());
        }

    }


}
