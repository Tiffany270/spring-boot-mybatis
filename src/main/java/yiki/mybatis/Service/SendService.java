package yiki.mybatis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yiki.mybatis.bean.User;
import yiki.mybatis.mapper.SendMapper;
import yiki.mybatis.mapper.UserYmlMapper;

import java.util.List;
import java.util.Map;

@Service
public class SendService {

    @Autowired
    private SendMapper sendMapper;

    public List<Map> getSendByCid(Integer cid) {
        return sendMapper.getSendByCid(cid);
    }

    public List<Map> getSendByUid(Integer uid) {
        return sendMapper.getSendByUid(uid);
    }


    public boolean updateSendStutas(Integer id, Integer replay) {

        return sendMapper.updateSendById(id, replay);
    }


}
