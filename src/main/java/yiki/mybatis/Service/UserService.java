package yiki.mybatis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import yiki.mybatis.bean.User;
import yiki.mybatis.mapper.UserYmlMapper;

public class UserService {

    @Autowired
    private UserYmlMapper usermapper;

    public void addUser(User user){
        usermapper.insertUser(user);
    }
}
