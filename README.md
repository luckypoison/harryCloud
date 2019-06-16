## 项目总结



eureka-server作为注册中心

eureka-client一共分为两种：

* 服务消费者

  1.Load balance会在这个服务中进行添加

  2.如果只是单纯的使用 **ribbon**的话，我们会使用RestTemplate进行调用，所以我们引入了**Feign**，它的作用不只是简化调用的过程，并且还包含了 loadbalance的作用，只要我们在 @FeignClient中填写提供者的名称（因为集群的名称和用途应该都是相同的），就会自动帮我们进行转发。

  3.分别为RestTemplate或者是Feign远程调用的方式，实现了**Hystrix**熔断器，为的就是如果被调用的一方出现了问题（包括宕机或者是超时的情况），可以退而求其次之，寻找一个还算说的过去的解决方案。

  * 简单的说如果是正常调用，我们使用@HystrixCommand，给出当前方法出错时，应该用什么方法。如果是使用Feign调用，我们就可以在@FeignClient中添加 fallback属性，然后通过实现feign的调用接口，在实现类中重写熔断的方法即可。

* 服务提供者

  * eureka-clientA
  * eureka-clientB

