package com.terrydr.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: 条件查询工具
 * @author: YanZhengYuan
 * @Date: 2018/4/18 14:19
 * @version: 1.00
 */
public class QueryUtils extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	//
	private int offset;
	// 每页条数
	private int limit;

	public QueryUtils(Map<String, Object> params) {
		this.putAll(params);
		// 分页参数
		this.offset = Integer.parseInt(params.get("offset").toString());
		this.limit = Integer.parseInt(params.get("limit").toString());
		this.put("offset", offset);
		this.put("page", offset / limit + 1);
		this.put("limit", limit);
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.put("offset", offset);
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
