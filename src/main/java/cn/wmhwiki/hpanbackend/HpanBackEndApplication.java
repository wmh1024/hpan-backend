package cn.wmhwiki.hpanbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("cn.wmhwiki.hpanbackend.mapper")
public class HpanBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(HpanBackEndApplication.class, args);
    }

}
