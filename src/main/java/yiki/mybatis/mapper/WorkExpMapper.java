package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import yiki.mybatis.bean.WorkExp;

import java.util.List;
import java.util.Map;

@Mapper
public interface WorkExpMapper {
    public boolean insertWorkExp(WorkExp workExp);

    public void updateWorkExp(WorkExp workExp);

    public List<Map> getWorkExpByUid(Integer uid);



}
