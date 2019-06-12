package cn.harry.cloud.eurekaclient.controller;

import cn.harry.cloud.eurekaclient.httpservice.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloController {
//region 使用feign之前的代码
//    @Autowired
//    @Qualifier("restTemplate")
//    private RestTemplate restTemplate;
//endregion
      @Autowired
      private HelloService helloService;
    @GetMapping
    public String hello(){
        //region 使用feign之前的代码
//        String responseMsg = this.restTemplate.getForObject("http://eureka-client-provider/hello,String.class);
        //endregion
        //上面便是没有使用feign之前的用法。
        String responseMsg = this.helloService.hello();
        System.out.println(responseMsg);
        return "responseMsg: "+responseMsg;
    }
}
