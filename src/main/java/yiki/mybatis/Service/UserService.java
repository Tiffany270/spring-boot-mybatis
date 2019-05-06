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
        User check = usermapper.getUserByName(user.getUname());
        if (check!=null){
            return false;
        }

        return usermapper.insertUser(user);
    }

    public User authUser(String uname, String upassword) {
        try {
            return usermapper.getUserByNameAndPassword(uname, upassword);
        } catch (Exception e) {
            return null;
        }
    }

}
