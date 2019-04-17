package yiki.mybatis.bean;

public class User {
    private Integer uid;
    private String uname;
    private String uemail;
    private String upassword;

    public User(String uname, String uemail, String upassword) {
        this.uname = uname;
        this.uemail = uemail;
        this.upassword = upassword;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }
}
