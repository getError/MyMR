package cn.geterror.mm.manager.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MsgController {
    @MessageMapping("/msg")
    @SendTo("/msg")
    public String ack(@Payload String s){
        return "ok";
    }
}
