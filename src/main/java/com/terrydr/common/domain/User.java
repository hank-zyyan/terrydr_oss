package com.terrydr.common.domain;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.domain
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 6/12/2018 10:07 AM
 * @version: 1.00
 */
public class User implements Principal{

    public User(String name){
        this.name = name;
    }

    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }
}
