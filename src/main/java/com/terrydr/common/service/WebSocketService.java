package com.terrydr.common.service;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.service
 * @Description: WebSocket服务接口
 * @author: YanZhengYuan
 * @Date: 7/3/2018 11:23 AM
 * @version: 1.00
 */
public interface WebSocketService {

    void sendToUser(String userName, String destination, Object payLoad);

    void sendToUser(String userName, String content);
}
