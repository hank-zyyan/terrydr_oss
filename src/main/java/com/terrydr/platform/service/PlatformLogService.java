package com.terrydr.platform.service;

import com.terrydr.platform.domain.PlatformLog;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service
 * @Description: 系统日志服务
 * @author: YanZhengYuan
 * @Date: 2018/6/28 15:22
 * @version: 1.00
 */
public interface PlatformLogService {
    long countByParams(Map<String, Object> params);

    List<PlatformLog> getLogsByParams(Map<String, Object> params);

    int saveLog(PlatformLog log);
}
