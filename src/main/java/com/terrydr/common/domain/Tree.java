package com.terrydr.common.domain;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.domain
 * @Description: 树结构
 * @author: YanZhengYuan
 * @Date: 6/13/2018 4:05 PM
 * @version: 1.00
 */
public abstract class Tree<T extends Tree> {

    private static final Log logger = LogFactory.getLog(Tree.class);

    /**
     * 节点ID
     */
    private Integer id;

    /**
     * 节点的子节点
     */
    private List<T> children;

    /**
     * 父节点ID
     */
    private Integer parentId;

    public abstract boolean hasParent();

    public abstract boolean hasChildren();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    /**
     * 遍历树
     * @param root
     * @return
     */
    public static <T extends Tree> List<T> traversal(T root){
        List<T> list = new ArrayList<>();
        if(root != null){
            Stack<T> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                T tree = stack.pop();
                list.add(tree);
                List cList;
                if((cList = tree.getChildren()) != null){
                    for(Object child : cList){
                        if(child != null){
                            stack.push((T)child);
                        }
                    }
                }
            }
        }
        logger.debug(list);
        return list;
    }

    /**
     * 根据数据库数据，生成root节点的树(只负责children字段的注入)，并放入数组
     * @param rootPid
     * @param treeMap
     * @param <E>
     * @return
     */
    public static <E extends Tree> List<E> buildTreesFromDB(Integer rootPid, Map<Integer, List<E>> treeMap) {
        List<E> list = new ArrayList<>();
        if(rootPid != null && treeMap != null){
            List<E> roots = treeMap.get(rootPid);
            for(E root : roots){
                Stack<E> stack = new Stack<>();
                list.add(root); //将树根放入结果集
                stack.push(root);
                stack(stack, treeMap);
            }
        }
        logger.debug(list);
        return list;
    }

    /**
     * 根据数据库数据，生成root节点的树(只负责children字段的注入)
     * @param rootPid
     * @param treeMap
     * @param <E>
     * @return
     */
    public static <E extends Tree> void buildTreeFromDB(Integer rootPid, Map<Integer, List<E>> treeMap, E rootTree) {
        if(rootPid != null && treeMap != null){
            List<E> roots = treeMap.get(rootPid);
            for(E root : roots){
                Stack<E> stack = new Stack<>();
                if(rootTree.getChildren() == null){
                    rootTree.setChildren(new ArrayList<E>());
                }
                rootTree.getChildren().add(root);//将树放入根
                stack.push(root);
                stack(stack, treeMap);
            }
        }
        logger.debug(rootTree);
    }

    private static <E extends Tree> void stack(Stack<E> stack, Map<Integer, List<E>> treeMap){
        if(stack == null){
            return;
        }
        while (!stack.isEmpty()){
            E tree = stack.pop();
            List<E> cList;
            if((cList = treeMap.get(tree.getId())) != null){
                for(E child : cList){
                    if(child != null){
                        if(tree.getChildren() == null){
                            tree.setChildren(new ArrayList<E>());
                        }
                        tree.getChildren().add(child);
                        stack.push(child);
                    }
                }
            }
        }
    }

}
