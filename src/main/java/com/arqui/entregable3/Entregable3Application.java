package com.arqui.entregable3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class Entregable3Application {

    public static void main(String[] args) {
        SpringApplication.run(Entregable3Application.class, args);
    }

}
