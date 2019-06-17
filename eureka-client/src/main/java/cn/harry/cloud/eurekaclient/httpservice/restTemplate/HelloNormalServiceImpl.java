package cn.harry.cloud.eurekaclient.httpservice.restTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloNormalServiceImpl implements HelloNormalService{

    //region 使用feign之前的代码
    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;
    //endregion


    @Override
    @HystrixCommand(fallbackMethod = "normalHelloFallback")
    public String normalHello() {
        return restTemplate.getForObject("http://eureka-client-provider-rogers/hello",String.class);
    }

    /**
     * 这个方法作为上一个方法的容错方法，如果上一个方法出现了问题。
     * 那么这个方法将会进行处理。
     * @return
     */
    public String normalHelloFallback(){
        return "这是普通方法，使用熔断器返回的数据";
    }
}
