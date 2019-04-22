package yiki.mybatis.bean;

/*属于user
 * 工作经验*/
public class WorkExp {
    private String name;    //公司名称
    private String type;    //行业类型
    private String ocp;     //职位
    private String dep;     //部门
    private String opcDate; //任职时间  time-time
    private String desc;    //详细

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOcp() {
        return ocp;
    }

    public void setOcp(String ocp) {
        this.ocp = ocp;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getOpcDate() {
        return opcDate;
    }

    public void setOpcDate(String opcDate) {
        this.opcDate = opcDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
