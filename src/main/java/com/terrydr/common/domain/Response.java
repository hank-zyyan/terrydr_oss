package com.terrydr.common.domain;

import com.terrydr.common.utils.Constant;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.domain
 * @Description: Response实体
 * @author: YanZhengYuan
 * @Date: 6/11/2018 3:08 PM
 * @version: 1.00
 */
public class Response extends OSSObject{
    /**
     * @see Constant.ResponseCode
     */
    private int code = Constant.ResponseCode.SUCCESS;
    private OSSObject responseObject;
    private String responseMessage;
    private long responseDate;

    public static Response success(String responseMessage, OSSObject responseObject){
        Response response = new Response();
        response.setResponseDate(System.currentTimeMillis());
        response.setResponseMessage(responseMessage);
        response.setResponseObject(responseObject);
        return response;
    }

    public static Response fail(String responseMessage, OSSObject responseObject){
        Response response = fail(responseMessage);
        response.setResponseObject(responseObject);
        return response;
    }

    public static Response fail(String responseMessage, int code){
        Response response = new Response();
        response.setResponseDate(System.currentTimeMillis());
        response.setResponseMessage(responseMessage);
        response.setCode(code);
        return response;
    }

    public static Response fail(String responseMessage){
        return fail(responseMessage, Constant.ResponseCode.FAIL);
    }

    public static Response fail(){
        return fail("操作失败!");
    }

    public static Response success(){
        return success("操作成功!", null);
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public long getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(long responseDate) {
        this.responseDate = responseDate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public OSSObject getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(OSSObject responseObject) {
        this.responseObject = responseObject;
    }

    @Override
    public Integer getId() {
        return null;
    }
}
