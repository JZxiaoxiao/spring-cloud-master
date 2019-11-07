# spring-cloud-master
## spring-cloud 项目整合
  
  注册中心：
  eureka 2.x 和 zuul ，Netflix官方没有提供开源，不建议使用。
  而nacos 作为Alibaba 孵化成功的项目，已经兼容了eureka和cloud-config 的功能，并且提供更加方便和简洁的配置，优先推荐。
  如果实在不想用nacos，也可以用zookeeper或者console，后续会更新对应项目配置。
  网关策略：
  gateway是spring-cloud官方团队孵化的项目，完全超越zuul，优先建议选择。
  负载均衡策略：
  ribbon+feign
  
  [spring-cloud 介绍](https://blog.csdn.net/forezp/article/details/83999882)
### [nacos](https://github.com/JZxiaoxiao/spring-cloud-master/tree/master/nacos)：cloud-Alibaba 注册中心与配置中心
  - 服务注册与发现
  - 配置中心支持
  - ribbon支持
  - feign支持
  - hystrix支持
### [eureka](https://github.com/JZxiaoxiao/spring-cloud-master/tree/master/eureka)：cloud 注册中心Eureka
  - 服务注册与发现
  - ribbon支持
  - feign支持
  - hystrix支持
  - 高可用Eureka 配置
### [cloud-config](https://github.com/JZxiaoxiao/spring-cloud-master/tree/master/cloud-config)：cloud 配置中心spring-cloud-config
  - 配置中心支持
### [Hystrix](https://github.com/JZxiaoxiao/spring-cloud-master/tree/master/hystrix)：cloud 断路器Hystrix 
  - ribbon支持
  - feign支持
  - hystrix支持
  - eureka支持
### [zuul](https://github.com/JZxiaoxiao/spring-cloud-master/tree/master/zuul)：cloud 网关策略zuul 
  - 路由支持
  - 过滤器filter支持
### [gateway](https://github.com/JZxiaoxiao/spring-cloud-master/tree/master/gateway)：cloud 网关策略gateway 
  - eureka支持
  - 过滤器filter支持
  - 限流支持
  - 路由支持

