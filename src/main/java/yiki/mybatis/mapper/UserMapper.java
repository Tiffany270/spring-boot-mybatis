package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yiki.mybatis.bean.User;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("select * from user where uid =#{uid}")
    public User getUserById(Integer uid);

    @Select("select * from user")
    public List<Map> getAllUser();

    @Delete("delete from user where uid =#{uid}")
    public int deleteUserById(Integer id);

    @Insert("insert into user(name) values(#{name)")
    public int insertUser(User user);
}
