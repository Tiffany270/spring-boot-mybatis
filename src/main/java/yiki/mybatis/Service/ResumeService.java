package yiki.mybatis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yiki.mybatis.bean.*;
import yiki.mybatis.mapper.ResumeMapper;
import yiki.mybatis.mapper.WorkExpMapper;
import yiki.mybatis.util.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private WorkExpMapper workExpMapper;

    public boolean checkPost(Integer uid, Integer jid) {
        Send checkRept = resumeMapper.getSendByUidAndJid(uid, jid);
        if (checkRept != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Deliver(Send send) {

        Send checkRept = resumeMapper.getSendByUidAndJid(send.getUid(), send.getJid());

        if (checkRept != null) {
            return false;
        }

        if (resumeMapper.deliver(send)) {
            return true;
        }
        return false;

    }


    public boolean updateResume(Map<String, Object> models) {
        try {

            Map<String, Object> resumeobj =
                    (Map<String, Object>) models.get("resume");
            ArrayList<Map<String, Object>> workExpList =
                    (ArrayList<Map<String, Object>>) models.get("workExps");

            Resume resume = JsonUtil.map2obj(resumeobj, Resume.class);
            resumeMapper.updateResume(resume);

            for (Map<String, Object> item : workExpList) {
                WorkExp workExp = JsonUtil.map2obj(item, WorkExp.class);
                workExpMapper.updateWorkExp(workExp);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }


    public boolean AddResume(Map<String, Object> models) {


        try {
            Map<String, Object> resumeobj =
                    (Map<String, Object>) models.get("resume");
            ArrayList<Map<String, Object>> workExpList =
                    (ArrayList<Map<String, Object>>) models.get("workExps");
            Resume resume = JsonUtil.map2obj(resumeobj, Resume.class);

            Resume checkRept = resumeMapper.getResumeByuid(resume.getUid());
            if (checkRept != null) {
                return false;
            }

            resumeMapper.insertResume(resume);
            for (Map<String, Object> item : workExpList) {
                WorkExp workExp = JsonUtil.map2obj(item, WorkExp.class);
                workExpMapper.insertWorkExp(workExp);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public Map<String, Object> getResume(Integer uid) {

        Map<String, Object> map = new HashMap<>();
        List<Map> wlist = workExpMapper.getWorkExpByUid(uid);

        Resume resume = resumeMapper.getResumeByuid(uid);

        map.put("workExps", wlist);
        map.put("resume", resume);

        return map;
    }
}
