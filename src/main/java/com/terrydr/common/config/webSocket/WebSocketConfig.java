package com.terrydr.common.config.webSocket;/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.config.webSocket
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 6/11/2018 11:12 AM
 * @version: 1.00
 */

import com.terrydr.common.webSocket.TerrydrWebSocketChannelInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

/**
 * @desc 描述 <br>
 * <p>
 * Copyright: Copyright (c)
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 * @author zyyan@terrydr.com
 * @version 1.0.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 配置stomp broker
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //配置前缀, 有这些前缀的会路由到broker
        registry.enableSimpleBroker("/topic", "/query")
                //配置stomp协议里, server返回的心跳
                .setHeartbeatValue(new long[]{10000l, 10000l})
                //配置发送心跳的scheduler
                .setTaskScheduler(new DefaultManagedTaskScheduler());
        //配置前缀, 有这些前缀的会被到有@SubscribeMapping与@MessageMapping的业务方法拦截,就是客户端发送给服务端用
        registry.setApplicationDestinationPrefixes("/app");
        //给指定用户发送（一对一）的主题前缀，不设置的话，默认也是/user/
        registry.setUserDestinationPrefix("/user");
    }

    /**
     * 配置连接点（客户端连入websocket的地址）
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/terrydr_websocket_server")
                //允许跨域
                .setAllowedOrigins("*")
                //支持SockJs协议,主要是允许html5
                .withSockJS();
        registry.addEndpoint("/terrydr_websocket_server");
    }

   /*
    * @Description: 配置request channel
    * @param registration
    * @throws
    * @author YanZhengYaun
    * @date 6/11/2018 2:42 PM
*/
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(new TerrydrWebSocketChannelInterceptor());
        registration.taskExecutor()
                .corePoolSize(32)
                .maxPoolSize(200)
                .queueCapacity(10000);
    }

   /*
    * @Description: 配置response channel
    * @param registration
    * @throws
    * @author YanZhengYaun
    * @date 6/11/2018 2:42 PM
*/
    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.taskExecutor()
                .corePoolSize(100)
                .maxPoolSize(400)
                .queueCapacity(20000);
    }

    /*
    * @Description: 配置消息传输参数，如过期时间，过期缓存大小等
    * @param registry
    * @throws
    * @author YanZhengYaun
    * @date 6/11/2018 2:46 PM
*/
    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry
                .setSendTimeLimit(15 * 1000)
                .setSendBufferSizeLimit(512 * 1024);
    }
}
