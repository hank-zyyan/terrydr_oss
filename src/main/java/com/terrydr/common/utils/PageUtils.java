package com.terrydr.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: 分页工具
 * @author: YanZhengYuan
 * @Date: 2018/4/18 14:19
 * @version: 1.00
 */
public class PageUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	private long total;
	private List<?> rows;

	public PageUtils(List<?> list, long total) {
		this.rows = list;
		this.total = total;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

    @Override
    public String toString() {
        return "PageUtils{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
