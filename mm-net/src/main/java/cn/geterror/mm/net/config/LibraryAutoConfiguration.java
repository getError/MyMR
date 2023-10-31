package cn.geterror.mm.net.config;

import cn.geterror.mm.net.web.socket.WebSocketConfig;
import cn.geterror.mm.net.web.socket.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.geterror.mm.net.web.socket")
public class LibraryAutoConfiguration {

}
