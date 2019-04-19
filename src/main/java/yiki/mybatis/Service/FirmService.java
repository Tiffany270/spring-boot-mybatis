package yiki.mybatis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yiki.mybatis.bean.Firm;
import yiki.mybatis.mapper.FirmMapper;

@Service
public class FirmService {

    @Autowired
    private FirmMapper firmMapper;

    public boolean addFirm(Firm firm) {
        return firmMapper.insertFirm(firm);
    }

    public Firm authFirm(String cname, String cpassword) {
        try {
            return firmMapper.getFirmByNameAndPassword(cname, cpassword);
        } catch (Exception e) {
            return null;
        }
    }

}
