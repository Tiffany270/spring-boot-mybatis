package yiki.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.Service.ResumeService;
import yiki.mybatis.Service.SendService;
import yiki.mybatis.bean.Send;

import java.util.List;
import java.util.Map;


@ResponseBody
@RestController
public class SendController {

    @Autowired
    private SendService sendService;


    @GetMapping("/send/{cid}")
    public List<Map> getSendByCid(@PathVariable("cid") Integer cid) {
        return sendService.getSendByCid(cid);
    }

    @GetMapping("/sendbyUser/{uid}")
    public List<Map> getSendByUid(@PathVariable("uid") Integer uid) {
        return sendService.getSendByUid(uid);
    }

    @PutMapping(value = "/replay/{id}")
    public int updateSendStatus(@PathVariable("id") Integer id, @RequestBody Send send) {



        if (sendService.updateSendStutas(id, send.getReplay())) {
            return 0;
        } else {
            return 1;
        }


    }


}
