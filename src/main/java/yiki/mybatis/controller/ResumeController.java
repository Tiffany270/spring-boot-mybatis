package yiki.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.Service.ResumeService;
import yiki.mybatis.bean.Send;

import java.util.Map;


@ResponseBody
@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/resume")
    public int addResume(@RequestBody Map<String, Object> models) {

        boolean res = resumeService.AddResume(models);
        if (res) {
            return 1;
        }

        return 0;
    }

    @GetMapping("/resume/{uid}")
    public Map<String, Object> getResumeByUid(@PathVariable("uid") Integer uid) {
        return resumeService.getResume(uid);
    }

    @PostMapping("/send")
    public int send(@RequestBody Send send) {
        boolean res = resumeService.Deliver(send);
        if (res) {
            return 1;
        }
        return 0;
    }

    @PostMapping("/checkPost")
    public int send(@RequestBody Map<String,Object> req) {
        Integer uid,jid;
        uid = (Integer)req.get("uid");
        jid = (Integer)req.get("jid");
        boolean res = resumeService.checkPost(uid,jid);
        System.out.println(res);
        if (res) {
            return 1;
        }
        return 0;
    }

}
