package com.terrydr.common.webSocket;

import com.terrydr.common.domain.User;
import com.terrydr.common.utils.OSSContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.webSocket
 * @Description: WebSocket 拦截器
 * @author: YanZhengYuan
 * @Date: 6/12/2018 8:35 AM
 * @version: 1.00
 */
public class TerrydrWebSocketChannelInterceptor extends ChannelInterceptorAdapter {
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            // 设置当前访问器的认证用户
            accessor.setUser(new User(OSSContext.getAccessToken()));
            /*Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);
            if (raw instanceof Map) {
                Object name = ((Map) raw).get("name");
                if (name instanceof LinkedList) {

                }
            }*/
        }
        return message;
    }
    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {

    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {

    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        return false;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        return null;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {

    }
}
