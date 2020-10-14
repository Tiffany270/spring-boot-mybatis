package yiki.mybatis.react_app_bean;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class UserSchema {
    private String userid;
    private String username;
    private String userpsw;
    private String usertype;
    private String intro;
    private String salary;
    private String company;
    private String occupation;
    private String userheader; // 头像

    public UserSchema() {
    }

    @Override
    public String toString() {
        return "UserSchema{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", userpsw='" + userpsw + '\'' +
                ", usertype='" + usertype + '\'' +
                ", userheader='" + userheader + '\'' +
                '}';
    }

    public UserSchema(String userid, String usertype) {
        this.userid = userid;
        this.usertype = usertype;
    }

    public UserSchema(String username,
                      String userpsw,
                      String usertype,
                      String userheader) {

        this.username = username;
        this.userpsw = userpsw;
        this.usertype = usertype;
        this.userheader = userheader;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public void setUserpsw(String userpsw) {
        this.userpsw = userpsw;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUserheader() {
        return userheader;
    }

    public void setUserheader(String userheader) {
        this.userheader = userheader;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
