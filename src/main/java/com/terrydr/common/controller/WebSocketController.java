package com.terrydr.common.controller;

import com.terrydr.common.utils.OSSContext;
import com.terrydr.common.webSocket.WebSocketMessage;
import com.terrydr.common.webSocket.WebSocketResponse;
import com.terrydr.platform.domain.PlatformUser;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.controller
 * @Description: websocket 控制转发器
 * @author: YanZhengYuan
 * @Date: 6/11/2018 2:33 PM
 * @version: 1.00
 */

@Controller
public class WebSocketController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WebSocketResponse welcome(WebSocketMessage message) throws InterruptedException {
        WebSocketResponse response = new WebSocketResponse();
        response.setResponseMessage(message.getContent());
        return response;
    }

    /**
     * 不是真正的单对单
     * @param message
     * @throws Exception
     */
    @MessageMapping("/message")
    public void userMessage(WebSocketMessage message) throws Exception {
        OSSContext.getWebSocketService().sendToUser(message.getReceiver(), "Hi," + message.getContent());
    }
}
