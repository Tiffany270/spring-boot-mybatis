package yiki.mybatis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yiki.mybatis.bean.User;
import yiki.mybatis.mapper.UserYmlMapper;

@Service
public class UserService {

    @Autowired
    private UserYmlMapper usermapper;

    public boolean addUser(User user) {
        return usermapper.insertUser(user);
    }

    public boolean authUser(String uname, String upassword) {
        return usermapper.getUserByNameAndPassword(uname,upassword);
    }

}
