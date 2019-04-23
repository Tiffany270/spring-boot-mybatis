package yiki.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.Service.ResumeService;
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

}
