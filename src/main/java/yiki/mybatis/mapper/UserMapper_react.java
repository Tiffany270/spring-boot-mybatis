package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import yiki.mybatis.react_app_bean.UserSchema;

@Mapper
public interface UserMapper_react {

    /*
    *   mybatis 默认
    *   一次只修改一条语句 成功返回 1
        一次修改两条及以上语句 成功返回 -1
        其他：捕捉插入异常
        */
    public int insertUser(UserSchema user) throws DataAccessException;
}
