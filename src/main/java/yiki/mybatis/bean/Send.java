package yiki.mybatis.bean;
//记录投递简历-公司 中间表
public class Send {

    private Integer id;     //唯一主键
    private Integer uid;    //投递人
    private Integer cid;    //被投递公司
    private Integer jid;    //职位主键
    private Integer replay; //是否接收面试
    // -1->未查看 0->已查看 1->面试 2->拒绝


    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getReplay() {
        return replay;
    }

    public void setReplay(Integer replay) {
        this.replay = replay;
    }
}
