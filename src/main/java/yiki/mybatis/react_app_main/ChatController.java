package yiki.mybatis.react_app_main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.react_app_bean.ChatSchema;
import yiki.mybatis.react_app_bean.UserSchema;
import yiki.mybatis.react_app_util.Result;

import java.util.List;
import java.util.Map;

@ResponseBody
@RestController
@RequestMapping("/react_chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/test")
    public Result test() {
        return Result.ok(chatService.getChatByCurrentLoginUser("2107ADB5F4FD", "招聘"));
    }

    @PostMapping("/postMsg")
    public Result postMsg(@RequestBody ChatSchema chat) {
        System.out.println(chat.toString());
        chatService.postMsg(chat);
        return Result.ok(chat.getChat_id());

    }

    @GetMapping("/ChatMsgFromId/{ChatId}")
    public Result getAllChatMsgFromId(@PathVariable("ChatId") String ChatId) {
        List list = chatService.getRecordsByUserId(ChatId);
        if (list.size() != 0) {
            return Result.ok(list);

        } else {
            return Result.error(404, "无数据");
        }
    }

    @PostMapping("/ChatMsgCurrentLoginUser")
    public Result getChatByCurrentLoginUser(@RequestBody UserSchema user) {
        Map map = chatService.getChatByCurrentLoginUser(user.getUserid(), user.getUsertype());
        if (map.size() != 0) {
            return Result.ok(map);
        } else {
            return Result.error(404, "无数据");

        }
    }

}
