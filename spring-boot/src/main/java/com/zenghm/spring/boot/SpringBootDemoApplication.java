package com.zenghm.spring.boot;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Create date:20/7/28.
 * Created by: zhm.
 * Class name:SpringBootApplication.
 */
@SpringBootApplication
//统一设置可以扫描mapper的路径
//@MapperScan("com.zenghm.spring.boot.mapper")
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class,args);
    }
}
