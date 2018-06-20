package com.terrydr.platform.domain;

import com.terrydr.common.domain.Tree;

import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.domain
 * @Description: 契合前端jsTree插件的对象
 * @author: YanZhengYuan
 * @Date: 2018/6/20 16:16
 * @version: 1.00
 */
public class JSTree extends Tree<JSTree> {

    public JSTree(PlatformMenu menu){
        super.setId(menu.getId());
        super.setParentId(menu.getParentMenuId());

        this.text = menu.getMenuName();
    }

    public JSTree(){
    }

    /**
     * 显示节点文本
     */
    private String text;
    /**
     * 节点状态，open closed
     */
    private Map<String, Object> state;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }

    @Override
    public boolean hasParent() {
        return super.getParentId() == null ? false : true;
    }

    @Override
    public boolean hasChildren() {
        return super.getChildren() == null ? false : super.getChildren().size() > 0;
    }
}
