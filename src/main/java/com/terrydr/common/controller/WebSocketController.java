package com.terrydr.common.controller;

import com.terrydr.common.webSocket.WebSocketMessage;
import com.terrydr.common.webSocket.WebSocketResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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

    //程序其他地方发送推送消息
    @Resource
    public SimpMessagingTemplate template;

    @MessageMapping("/welcome")
    @SendTo("/topic/comeIn")
    public WebSocketResponse welcome(WebSocketMessage message) throws InterruptedException {
        Thread.sleep(10000);
        WebSocketResponse response = new WebSocketResponse();
        response.setResponseMessage("welcome you！");
        return response;
    }

    /**
     * 不是真正的单对单
     * @param message
     * @param principal
     * @return
     * @throws Exception
     */
    @MessageMapping("/message")
    @SendToUser("/query")
    public WebSocketResponse userMessage(WebSocketMessage message,Principal principal) throws Exception {
        WebSocketResponse response = new WebSocketResponse();
        response.setResponseMessage("Hi," + principal.getName());
        return response;
    }
}
