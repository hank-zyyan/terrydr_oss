package com.terrydr.common.webSocket;

import com.terrydr.common.domain.Response;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.webSocket
 * @Description: WebSocket Response实体
 * @author: YanZhengYuan
 * @Date: 6/11/2018 3:12 PM
 * @version: 1.00
 */
public class WebSocketResponse extends Response{

    public static WebSocketResponse response(String msg){
        WebSocketResponse webSocketResponse = new WebSocketResponse();
        webSocketResponse.setResponseDate(System.currentTimeMillis());
        webSocketResponse.setResponseMessage(msg);
        return webSocketResponse;
    }
}
