package yiki.mybatis.react_app_main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yiki.mybatis.react_app_bean.ChatSchema;
import yiki.mybatis.react_app_util.Result;

@ResponseBody
@RestController
@RequestMapping("/react_chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/test")
    public Result getAllChatMsgFromId(){
        chatService.chatSendMsg();
        return null;
    }

    @PostMapping("/postMsg")
    public Result postMsg(@RequestBody ChatSchema chat){
        System.out.println(chat.toString());
        chatService.postMsg(chat);
        return Result.ok(chat.getChat_id());

    }

}
