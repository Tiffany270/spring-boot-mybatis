package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import yiki.mybatis.bean.User;

import java.util.List;

@Mapper
public interface UserYmlMapper {

    //增删查改

    public User getUserById(Integer uid);

    public boolean insertUser(User user);

    public List<User> getUsers();

    public boolean updateUser(User user);

    public boolean deleteUser(int id);

    public boolean deleteAllUsers();


}
