package com.example.springsoapconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class EmployeeConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.springsoapconsumer.wsdl");
        return marshaller;
    }

    @Bean
    public EmployeeClient employeeClient(Jaxb2Marshaller marshaller){
        EmployeeClient client = new EmployeeClient();
        client.setDefaultUri("http://localhost:7777/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
