package com.terrydr.common.webSocket;

import com.terrydr.common.domain.Message;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.MimeType;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;

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
public class WebSocketClient {

    public static void main(String[] args) {
        org.springframework.web.socket.client.WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient webSocketStompClient = new WebSocketStompClient(webSocketClient);
        //配置convert, 这里配置了对象与json互转
        webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());
        //配置心跳
        webSocketStompClient.setDefaultHeartbeat(new long[]{10000l, 10000l});
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.afterPropertiesSet();
        webSocketStompClient.setTaskScheduler(taskScheduler);
        //连接
        webSocketStompClient.connect("ws://127.0.0.1:8080/echo", new MyHandler());

        try {
            //hang信进程, 如果不hang, 进程线程websocket连接也就都关闭了
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler implements StompSessionHandler {
        @Override
        public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
            stompSession.subscribe("/topic/comeIn", new StompFrameHandler() {
                @Override
                public Type getPayloadType(StompHeaders headers) {
                    return Message.class;
                }

                @Override
                public void handleFrame(StompHeaders headers, Object payload) {
                    System.out.println("收到消息:" + payload);
                }
            });

            StompHeaders sendStompHeaders = new StompHeaders();
            stompHeaders.setDestination("/topic/welcome");
            stompHeaders.setContentType(MimeType.valueOf("application/json;charset=utf-8"));

            //这个Message是我自己随便定义的一个结构体, 这个可以自己定义
            Message message = new WebSocketMessage();
            message.setContent("hello world!");

            stompSession.send(sendStompHeaders, message);
        }

        @Override
        public void handleException(StompSession stompSession, StompCommand stompCommand, StompHeaders stompHeaders, byte[] bytes, Throwable throwable) {
            System.out.println("handleException");
        }

        @Override
        public void handleTransportError(StompSession stompSession, Throwable throwable) {
            System.out.println("handleTransportError");
            throwable.printStackTrace();
        }

        @Override
        public Type getPayloadType(StompHeaders stompHeaders) {
            System.out.println("getPayloadType");
            return null;
        }

        @Override
        public void handleFrame(StompHeaders stompHeaders, Object o) {
            System.out.println("handleFrame");
        }
    }
}
