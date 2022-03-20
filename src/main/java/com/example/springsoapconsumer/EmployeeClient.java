package com.example.springsoapconsumer;

import com.example.springsoapconsumer.wsdl.GetEmployeeByIdRequest;
import com.example.springsoapconsumer.wsdl.GetEmployeeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.example.springsoapconsumer.*;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class EmployeeClient  extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(EmployeeClient.class);
    public GetEmployeeResponse getEmployee(Integer empId){
        GetEmployeeByIdRequest request = new GetEmployeeByIdRequest();
        request.setEmployeeId(empId);

        log.info("Reqesting location for " + empId);

        GetEmployeeResponse response = (GetEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7777/ws/employees", request,
                        new SoapActionCallback("http://springsoap.example.com/getEmployeeByIdRequest"));
        return response;
    }
}
