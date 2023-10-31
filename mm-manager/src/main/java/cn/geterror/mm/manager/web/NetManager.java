package cn.geterror.mm.manager.web;

import cn.geterror.mm.net.web.socket.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NetManager {
    @Autowired
    WebSocketHandler webSocketHandler;
}
