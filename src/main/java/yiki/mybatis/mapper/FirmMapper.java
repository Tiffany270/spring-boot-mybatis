package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import yiki.mybatis.bean.Firm;
import yiki.mybatis.bean.FirmInfo;
import yiki.mybatis.bean.JobDes;

import java.util.List;
import java.util.Map;

@Mapper
public interface FirmMapper {


    //----Firm JD

    public boolean insertJD(JobDes jobDes);

    public List<Map> getAllJD();

    public List<Map> getJDbyCid(Integer cid);

    public JobDes getJDbyJid(Integer jid);

    public List<Map> getJDListByKey(String key);


    //----Firm info

    public boolean insertFirmInfo(FirmInfo firmInfo);

    public FirmInfo getFirmInfoByCid(Integer cid);

    public List<Map> getAllFirmInfo();

    //------- Firm
    public Firm getFirmById(Integer cid);

    public Firm getFirmByName(String cname);


    public boolean insertFirm(Firm firm);

    public List<Firm> getFirms();

    public boolean updateFirm(Firm user);

    public boolean deleteFirm(int cid);

    public boolean deleteAllFirms();


    public Firm getFirmByNameAndPassword(String cname, String cpassword);


}
