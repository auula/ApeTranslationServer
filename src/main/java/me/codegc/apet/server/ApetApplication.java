package me.codegc.apet.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class ApetApplication {


    public static void main(String[] args) {
        log.info("{} >>>> 程序正在启动", new Date());
        SpringApplication.run(ApetApplication.class, args);
    }


}
