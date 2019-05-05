package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SendMapper {

    public boolean updateSendById(Integer id, Integer replay);

    public List<Map> getSendByCid(Integer cid);

    public List<Map> getSendByUid(Integer uid);

}
