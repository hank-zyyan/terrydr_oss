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
    //缓存方式
    public static final String CACHE_TYPE_REDIS ="redis";

    public static final String LOG_ERROR = "error";

    public static final String ACCESS_TOKEN_KEY = "access_token";

}
