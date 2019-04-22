package yiki.mybatis.bean;

/*属于user
 * 工作经验*/
public class WorkExp {
    private Integer id;
    private Integer uid;
    private String name;    //公司名称
    private String type;    //行业类型
    private String ocp;     //职位
    private String dep;     //部门
    private String opcDate; //任职时间  time-time
    private String text;    //详细

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "WorkExp{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", ocp='" + ocp + '\'' +
                ", dep='" + dep + '\'' +
                ", opcDate='" + opcDate + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

