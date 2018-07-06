package com.terrydr.common.service.impl;

import com.terrydr.common.service.WebSocketService;
import com.terrydr.common.utils.Constant;
import com.terrydr.common.webSocket.WebSocketResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.service.impl
 * @Description: WebSocket服务实现类
 * @author: YanZhengYuan
 * @Date: 7/3/2018 11:24 AM
 * @version: 1.00
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {

    private Log logger = LogFactory.getLog(WebSocketServiceImpl.class);

    @Resource
    public SimpMessagingTemplate template;

    @Override
    public void sendToUser(String userName, String content) {
        sendToUser(userName, Constant.DEFAULT_DESTINATION, WebSocketResponse.response(content));
    }

    @Override
    public void sendToUser(String userName, String destination, Object payload) {
        logger.debug("userName: " + userName + ", destination:" + destination + ", payload:" + payload);
        template.convertAndSendToUser(userName, destination, payload);
    }
}
