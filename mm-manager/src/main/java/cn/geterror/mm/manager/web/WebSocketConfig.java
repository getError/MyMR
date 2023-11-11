package cn.geterror.mm.manager.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

import java.util.List;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer, WebSocketMessageBrokerConfigurer {
    @Autowired
    WebSocketHandler handler;

    @Value("${server.socket.msg-path-prefix}")
    String msgPathPrefix;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler, msgPathPrefix)
                .setAllowedOrigins("*");
    }
    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        messageConverters.add(converter);
        return true;
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

// registry.enableSimpleBroker("/topic");
// registry.setApplicationDestinationPrefixes("/app");

        //基于内存的STOMP消息代理
        registry.enableSimpleBroker("/queue", "/topic");

        //基于RabbitMQ 的STOMP消息代理
        /* registry.enableStompBrokerRelay("/queue", "/topic") .setRelayHost(host) .setRelayPort(port) .setClientLogin(userName) .setClientPasscode(password);*/

// registry.setApplicationDestinationPrefixes("/app", "/foo");
        registry.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // registry.addEndpoint("/gs-guide-websocket").withSockJS();
        // registry.addEndpoint("/webSocketServer").setAllowedOrigins("*").withSockJS();
        registry.addEndpoint("/msg").withSockJS();
    }

}