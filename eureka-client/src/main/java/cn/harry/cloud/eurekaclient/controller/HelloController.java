package cn.harry.cloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @GetMapping
    public String hello(){
        String responseMsg = this.restTemplate.getForObject("http://eureka-client-provider/hello",String.class);
        System.out.println(responseMsg);
        return "responseMsg: "+responseMsg;
    }
}
