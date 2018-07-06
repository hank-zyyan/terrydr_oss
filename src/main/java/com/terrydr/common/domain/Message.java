package com.terrydr.common.domain;

import java.util.Date;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.domain
 * @Description: 消息实体
 * @author: YanZhengYuan
 * @Date: 6/11/2018 3:05 PM
 * @version: 1.00
 */
public class Message {

    public Message(){
        this.timestamp = System.currentTimeMillis();
    }

    private String content;
    private long timestamp;
    private String sender;
    private String receiver;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
