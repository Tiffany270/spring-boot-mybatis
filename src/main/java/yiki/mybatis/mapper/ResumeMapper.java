package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import yiki.mybatis.bean.Resume;

@Mapper
public interface ResumeMapper {

    public boolean insertResume(Resume resume);
}
