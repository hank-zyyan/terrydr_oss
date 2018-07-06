package com.terrydr.common.utils;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: 全局常量
 * @author: YanZhengYuan
 * @Date: 2018/5/4 14:38
 * @version: 1.00
 */
public class Constant {
    //自动去除表前缀
    public static final String AUTO_REOMVE_PRE = "true";

    //停止计划任务
    public static final String STATUS_RUNNING_STOP = "stop";
    //开启计划任务
    public static final String STATUS_RUNNING_START = "start";

    //通知公告阅读状态-未读
    public static final String OA_NOTIFY_READ_NO = "0";
    //通知公告阅读状态-已读
    public static final int OA_NOTIFY_READ_YES = 1;

    //部门根节点id
    public static final Long DEPT_ROOT_ID = 0l;

    //缓存
    public static final String CACHE_TYPE_REDIS ="redis";

    public static final String LOG_ERROR = "error";

    public static final String ACCESS_TOKEN_KEY = "access_token";

    public static final String VERIFY_CODE_CACHE_NAME = "verifyCode";

    //异常
    public static final String ERROR_PATH = "/error";

    //Response Code
    public static final class ResponseCode{
        public static final int SUCCESS = 0;
        public static final int FAIL = 1;

        public static final int NOT_AUTHENTICATED = 1401;
        public static final int FOBBIDEN = 1403;
        public static final int NOT_FOUND = 1404;
        public static final int INNER_ERROR = 1500;
    }

    //Menu
    public static final class Menu{
        public static final int FIRST = 1;
        public static final int SECOND = 2;
        public static final int THIRD = 3;

        public static final int ROOT_PARENT_ID = 0;
    }

    //Shiro Session Name
    public static final String SESSION_ID_COOKIE_NAME = "COM.TERRYDR.SESSIONID.COOKIE";


    //WebSocket
    public static final String DEFAULT_DESTINATION = "/query";

}
