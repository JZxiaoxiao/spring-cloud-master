package com.jun.gatewaylimit.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Jun
 * @version 1.0
 * @ClassName HostAddrKeyResolver
 * @Description KeyResolver需要实现resolve方法，比如根据Hostname进行限流，则需要用hostAddress去判断。实现完KeyResolver之后，需要将这个类的Bean注册到Ioc容器中
 * @date 2019/11/7 15:22
 */
public class HostAddrKeyResolver implements KeyResolver {

    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

}



//可以根据uri去限流：

//public class UriKeyResolver  implements KeyResolver {
//
//    @Override
//    public Mono<String> resolve(ServerWebExchange exchange) {
//        return Mono.just(exchange.getRequest().getURI().getPath());
//    }
//
//}
//
//    @Bean
//    public UriKeyResolver uriKeyResolver() {
//        return new UriKeyResolver();
//    }


    //也可以以用户的维度去限流：
//    @Bean
//    KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
//    }