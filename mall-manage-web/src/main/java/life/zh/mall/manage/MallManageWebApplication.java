package life.zh.mall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //加上这句
public class MallManageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallManageWebApplication.class, args);
    }

}
