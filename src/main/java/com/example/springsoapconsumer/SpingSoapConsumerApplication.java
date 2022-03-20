package com.example.springsoapconsumer;

import com.example.springsoapconsumer.wsdl.GetEmployeeResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpingSoapConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingSoapConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(EmployeeClient quoteClient){
        return args -> {
            Integer emId = 1;
            if(args.length>0){
                emId = Integer.valueOf(args[0]);
            }
            GetEmployeeResponse response = quoteClient.getEmployee(emId);
            System.err.println(response.getEmployeeInfo().getEmployeeId());
            System.err.println(response.getEmployeeInfo().getName());
            System.err.println(response.getEmployeeInfo().getDepartment());
            System.err.println(response.getEmployeeInfo().getAddress());
            System.err.println(response.getEmployeeInfo().getPhone());
        };
    }
}
