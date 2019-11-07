package com.jun.gatewayfilter;

import com.jun.gatewayfilter.filter.RequestTimeFilter;
import com.jun.gatewayfilter.filter.RequestTimeGatewayFilterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterApplication.class, args);
    }

    /**
     * @Author JZxiaoxiao
     * @Description 第一种方式：自定义过滤器 模式
     * @Date 2019/11/7 14:41
     *
     * 创建的route可以让请求“/customer/**” 的请求都转发到“http://httpbin.org:80/get”
     * 并且过滤器打印：
     * 2019-11-06 17:39:04.432  INFO 19640 --- [ctor-http-nio-4] o.s.cloud.gateway.filter.GatewayFilter   : /customer: 572ms
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p.path("/customer/**")
//                        //使用自定义 filter：RequestTimeFilter
//                        .filters(f -> f.filter(new RequestTimeFilter())
//                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
//                        .uri("http://httpbin.org:80/get")
//                        .order(0)
//                        .id("customer_filter_router")
//                ).build();
//    }

    /**
     * @Author JZxiaoxiao
     * @Description 第二种模式：自定义过滤器工厂
     * @Date 2019/11/7 14:43
     * @Param []
     * @return RequestTimeGatewayFilterFactory
     *
     * 需要配置 配置文件 route
     * spring:
     *   profiles:
     *     active: elapse_route
     *
     * ---
     * spring:
     *   cloud:
     *     gateway:
     *       routes:
     *       - id: elapse_route
     *         uri: http://httpbin.org:80/get
     *         filters:
     *         - RequestTime=false
     *         predicates:
     *         - After=2017-01-20T17:42:47.789-07:00[America/Denver]
     *   profiles: elapse_route
     */
    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }
}
