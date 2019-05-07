package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import yiki.mybatis.bean.Resume;
import yiki.mybatis.bean.Send;

@Mapper
public interface ResumeMapper {

    //post resume to company
    public boolean deliver(Send send);

    public Send getSendByUidAndJid(Integer uid, Integer jid);

    //----resume
    public boolean insertResume(Resume resume);

    public void updateResume(Resume resume);

    public Resume getResumeByuid(Integer uid);
}
