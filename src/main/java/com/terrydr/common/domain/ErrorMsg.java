package com.terrydr.common.domain;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.domain
 * @Description: 返回给客户端的Error信息
 * @author: YanZhengYuan
 * @Date: 6/14/2018 1:45 PM
 * @version: 1.00
 */
public class ErrorMsg {

    private String exception;
    private String url;

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
