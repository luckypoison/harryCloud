package cn.harry.cloud.eurekaclient.httpservice.feign;

import org.springframework.stereotype.Component;

/**
 * 这个类专门用于容错使用，继承了feign远程调用的接口
 */

@Component
public class HelloFallbackService implements HelloService{

    /**
     *保证方法名和参数列表相同
     * @return
     */
    @Override
    public String hello() {
        return "对不起，你要访问的业务出了点问题";
    }
}
