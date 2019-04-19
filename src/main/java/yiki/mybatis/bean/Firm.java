package yiki.mybatis.bean;

public class Firm {
    private Integer cid;
    private String clabelname;
    private String cname;
    private String cemail;
    private String cpassword;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getClabelname() {
        return clabelname;
    }

    public void setClabelname(String clabelname) {
        this.clabelname = clabelname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
}
