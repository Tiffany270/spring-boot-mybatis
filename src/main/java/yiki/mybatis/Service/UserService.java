package yiki.mybatis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import yiki.mybatis.bean.User;
import yiki.mybatis.mapper.UserYmlMapper;

@Service
public class UserService {

    @Autowired
    private UserYmlMapper usermapper;

    public boolean addUser(User user) {
        return usermapper.insertUser(user);
    }

}
