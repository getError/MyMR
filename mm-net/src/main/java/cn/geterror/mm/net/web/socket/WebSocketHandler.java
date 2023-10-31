package cn.geterror.mm.net.web.socket;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.apache.logging.log4j.Logger;
@Component
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 当建立WebSocket连接时触发
        log.info("链接已建立");
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 处理接收到的文本消息
        String receivedMessage = message.getPayload();
        log.info("接收到消息：" + receivedMessage);
        // 发送消息给客户端
        String responseMessage = "你发送了消息：" + receivedMessage;
        session.sendMessage(new TextMessage(responseMessage));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 当WebSocket连接关闭时触发
        log.info("WebSocket连接已关闭");
        super.afterConnectionClosed(session, status);
    }
}
