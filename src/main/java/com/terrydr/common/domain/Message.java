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
    private String content;
    private Date msgDate;
    private String sender;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
