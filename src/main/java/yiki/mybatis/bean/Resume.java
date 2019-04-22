package yiki.mybatis.bean;

/*
 * 属user
 * 简历*/


import java.util.List;

public class Resume {
    private Integer uid;            //主键就是uid
    //所属的简历持有用户
    private String name;            //姓名
    private String email;           //邮箱
    private String phone;           //电话
    private String region;          //所在地区
    private String school;          //院校
    private String degree;          //学历
    private String age;             //年龄
    private String self;            //自我评价
    private String occupation;      //期望职位
    private String type;            //职业类型
    private String status;          //现在的状态
    private String pay;             //期望薪资
    private List<WorkExp> workExps;          //工作经验
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", region='" + region + '\'' +
                ", school='" + school + '\'' +
                ", degree='" + degree + '\'' +
                ", age='" + age + '\'' +
                ", self='" + self + '\'' +
                ", occupation='" + occupation + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", pay='" + pay + '\'' +
                ", workExps='" + workExps + '\'' +
                '}';
    }

    public List<WorkExp> getWorkExps() {
        return workExps;
    }

    public void setWorkExps(List<WorkExp> workExps) {
        this.workExps = workExps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
