package com.viclim.soup.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IGAccountDemo {
    public static void main(String...args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(IGAccountDemo.class, args);
        Thread.sleep(3000);
        ctx.close();
    }
}
