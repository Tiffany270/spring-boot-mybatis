package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yiki.mybatis.bean.User;

@Mapper
public interface UserMapper {

    @Select("select * from user where id =#{id}")
    public User getUserById(Integer id);


    @Insert("insert into user(name) values(#{name)")
    public int insertUser(User user);
}
