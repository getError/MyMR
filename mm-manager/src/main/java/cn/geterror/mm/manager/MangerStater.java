package cn.geterror.mm.manager;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="cn.geterror.mm.net.web.socket")
public class MangerStater {
    public static void main(String[] args) {
        SpringApplication.run(MangerStater.class, args);
    }
}