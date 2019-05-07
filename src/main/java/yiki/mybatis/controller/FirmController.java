package yiki.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.Service.FirmService;
import yiki.mybatis.bean.FirmInfo;
import yiki.mybatis.bean.JobDes;

import java.util.List;
import java.util.Map;

@ResponseBody
@RestController
public class FirmController {

    @Autowired
    private FirmService firmService;

    //-----info

    @PostMapping("/JD")
    public int addJD(@RequestBody JobDes jobDes) {

        boolean res = firmService.addJd(jobDes);
        if (res) {
            return 1;
        }

        return 0;
    }

    @GetMapping("/JD/{jid}")
    public JobDes getJDByJid(@PathVariable("jid") Integer jid) {
        return firmService.getJDbyJid(jid);
    }

    @GetMapping("/JDbyC/{cid}")
    public List<Map> getJDByCid(@PathVariable("cid") Integer cid){
        return firmService.getJDbyCid(cid);
    }
    @GetMapping("/allJD")
    public List<Map> getAllJD(){
        return firmService.getAllJD();
    }

    //-----info

    @PostMapping("/firmInfo")
    public int addFirmInfo(@RequestBody FirmInfo firmInfo) {

        boolean res = firmService.addFirmInfo(firmInfo);
        if (res) {
            return 1;
        }


        return 0;
    }

    @GetMapping("/firmInfo/{cid}")
    public FirmInfo getFirmInfoBycid(@PathVariable("cid") Integer cid) {
        return firmService.getFirmInfoBycid(cid);
    }

    @GetMapping("/allFirmInfo")
    public List<Map> getAllFirmInfo(){
       return firmService.getAllFirmInfoLimit();
    }

    @GetMapping("/job/{key}")
    public List<Map> getJDbyKey(@PathVariable("key") String key){
        System.out.println(key);
        return  firmService.getJDbyKey(key);
    }
}
