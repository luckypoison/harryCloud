package cn.harry.cloud.eurekaclient.controller;

import cn.harry.cloud.eurekaclient.httpservice.feign.HelloService;
import cn.harry.cloud.eurekaclient.httpservice.restTemplate.HelloNormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

      @Autowired
      private HelloService helloService;

      @Autowired
      private HelloNormalService normalService;
    @GetMapping
    public String feignHello(){
        //region 使用feign之前的代码
//        String responseMsg = this.restTemplate.getForObject("http://eureka-client-provider/hello,String.class);
        //endregion
        //上面便是没有使用feign之前的用法。
        String responseMsg = this.helloService.hello();
        System.out.println(responseMsg);
        return "responseMsg: "+responseMsg;
    }

    @GetMapping("/normal")
    public String normalHello(){
        String responseMsg = this.normalService.normalHello();
        System.out.println(responseMsg);
        return "responseMsg: "+responseMsg;
    }
}
