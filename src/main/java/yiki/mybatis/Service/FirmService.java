package yiki.mybatis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yiki.mybatis.bean.Firm;
import yiki.mybatis.bean.FirmInfo;
import yiki.mybatis.bean.JobDes;
import yiki.mybatis.mapper.FirmMapper;

import java.util.List;
import java.util.Map;

@Service
public class FirmService {

    @Autowired
    private FirmMapper firmMapper;


    //----Firm info
    public boolean addFirmInfo(FirmInfo firmInfo) {

        try {
            FirmInfo checkRept = firmMapper.getFirmInfoByCid(firmInfo.getCid());
            if (checkRept != null) {
                return false;
            }
            firmMapper.insertFirmInfo(firmInfo);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public FirmInfo getFirmInfoBycid(Integer cid) {
        return firmMapper.getFirmInfoByCid(cid);
    }


    //----Firm
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

    public List<Map> getAllFirmInfoLimit() {
        return firmMapper.getAllFirmInfo();
    }

    //----Firm JD
    public boolean addJd(JobDes jobDes) {
        return firmMapper.insertJD(jobDes);
    }

    public JobDes getJDbyJid(Integer jid) {
        return firmMapper.getJDbyJid(jid);
    }

    public List<Map> getAllJD() {
        return firmMapper.getAllJD();
    }

    public List<Map> getJDbyCid(Integer cid) {
        return firmMapper.getJDbyCid(cid);
    }


}