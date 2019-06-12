## 项目总结



eureka-server作为注册中心

eureka-client一共分为两种：

* 服务消费者

  1.Load balance会在这个服务中进行添加

  2.如果只是单纯的使用 **ribbon**的话，我们会使用RestTemplate进行调用，所以我们引入了**Feign**，它的作用不只是简化调用的过程，并且还包含了 loadbalance的作用，只要我们在 @FeignClient中填写提供者的名称（因为集群的名称和用途应该都是相同的），就会自动帮我们进行转发。

* 服务提供者

  * eureka-clientA
  * eureka-clientB

