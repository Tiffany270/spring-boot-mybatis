package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yiki.mybatis.bean.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface AutoMapper {

    @Select("select * from firm")
    public List<Map> getAllfirm();

    @Delete("delete from firm where cid =#{cid}")
    public int deleteFirmById(Integer cid);

}
