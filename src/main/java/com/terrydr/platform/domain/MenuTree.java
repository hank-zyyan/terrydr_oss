package com.terrydr.platform.domain;


import com.terrydr.common.domain.Tree;

import java.util.ArrayList;


/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.domain
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 6/13/2018 4:11 PM
 * @version: 1.00
 */
public class MenuTree extends Tree<MenuTree> {

    public MenuTree(PlatformMenu menu){
        super.setId(menu.getId());
        super.setParentId(menu.getParentMenuId());
        super.setChildren(new ArrayList<>());

        this.name = menu.getMenuName();
        this.url = menu.getMenuUrl();
        this.style = menu.getStyle();
        this.level = menu.getMenuLevel();
    }

    /**
     * 给页面用的
     */
    public boolean isHasChild() {
        return this.hasChildren();
    }

    /**
     * 菜单名
     */
    private String name;

    /**
     * 菜单url
     */
    private String url;

    /**
     * 菜单样式
     */
    private String style;

    /**
     * 菜单级别
     */
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void addChildren(MenuTree tree){
        if (getChildren() == null){
            super.setChildren(new ArrayList<>());
        }
        getChildren().add(tree);
    }

    @Override
    public boolean hasParent() {
        return super.getParentId() == 0 ? false : true;
    }

    @Override
    public boolean hasChildren() {
        return super.getChildren().size() > 0;
    }

}
