package cn.harry.cloud.eurekaclient.httpservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个注解具有load balance的功效，可以替代 @ LoadBalanced注解
 * 并且我们只需要使用接口，并且借助spring mvc的注解，便可以简化调用
 * 使用这个调用的地方在{@link cn.harry.cloud.eurekaclient.controller.HelloController}
 */
@FeignClient(name = "eureka-client-provider-rogers", fallback = HelloFallbackService.class)
public interface HelloService {
    @GetMapping("/hello")
    public String hello();
}
