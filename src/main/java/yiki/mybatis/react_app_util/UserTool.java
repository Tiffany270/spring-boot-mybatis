package yiki.mybatis.react_app_util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class UserTool {
    static private String salt = "yiki";


    // 给密码md加密和解密

    // md5加密
    static public String setUserpsw(String userpsw) {
        String saltPassword = salt + "/" + userpsw;
        String md5Password = DigestUtils.md5DigestAsHex(saltPassword.getBytes());
        return md5Password;
    }

    // 自动生成UUID
    static public String setUserid(String userid) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        String[] ids = id.split("-");
       return (ids[0] + ids[1]).toUpperCase();
    }
}
