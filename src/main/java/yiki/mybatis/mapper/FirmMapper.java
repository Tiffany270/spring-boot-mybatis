package yiki.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import yiki.mybatis.bean.Firm;

import java.util.List;

@Mapper
public interface FirmMapper {


    public Firm getFirmById(Integer cid);

    public boolean insertFirm(Firm firm);

    public List<Firm> getFirms();

    public boolean updateFirm(Firm user);

    public boolean deleteFirm(int cid);

    public boolean deleteAllFirms();

    public Firm getFirmByNameAndPassword(String cname, String cpassword);


}
