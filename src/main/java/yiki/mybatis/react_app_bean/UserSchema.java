package yiki.mybatis.react_app_bean;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class UserSchema {
    private String userid;
    private String username;
    private String userpsw;
    private String usertype;
    private String userheader; // 头像
    private String salt = "yiki";

    @Override
    public String toString() {
        return "UserSchema{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", userpsw='" + userpsw + '\'' +
                ", usertype='" + usertype + '\'' +
                ", userheader='" + userheader + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    public String getUserid() {

        return this.userid;
    }

    public UserSchema(String username,
                      String userpsw,
                      String usertype,
                      String userheader) {

        this.setUserid("auto create");
        this.username = username;
        this.setUserpsw(userpsw);
        this.usertype = usertype;
        this.userheader = userheader;
    }

    // 随机生成UUID
    public void setUserid(String userid) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        String[] ids = id.split("-");
        this.userid = (ids[0] + ids[1]).toUpperCase();
    }

    public String getUserheader() {
        return userheader;
    }

    public void setUserheader(String userheader) {
        this.userheader = userheader;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpsw() {
        return userpsw;
    }

    // md5加密
    public void setUserpsw(String userpsw) {

        String saltPassword = salt + "/" + userpsw;
        String md5Password = DigestUtils.md5DigestAsHex(saltPassword.getBytes());
        this.userpsw = md5Password;

    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
