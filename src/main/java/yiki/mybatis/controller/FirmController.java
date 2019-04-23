package yiki.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.Service.FirmService;
import yiki.mybatis.bean.FirmInfo;

import java.util.List;
import java.util.Map;

@ResponseBody
@RestController
public class FirmController {

    @Autowired
    private FirmService firmService;

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
}
