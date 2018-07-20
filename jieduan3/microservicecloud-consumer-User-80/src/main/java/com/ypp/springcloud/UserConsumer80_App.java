package com.ypp.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class UserConsumer80_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserConsumer80_App.class, args);
    }
}