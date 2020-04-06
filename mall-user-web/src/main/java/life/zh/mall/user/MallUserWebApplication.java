package life.zh.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//不需要注册datasource
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //加上这句
public class MallUserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUserWebApplication.class, args);
    }

}
