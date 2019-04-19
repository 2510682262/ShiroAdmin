package com.qfedu.shiroadmin.common.vo;

import java.util.List;

public class MenuVo {

    private Integer id;

    private String icon;

    private String name;

    private List<MenuVo> childs;

    private String perms;

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuVo> getChilds() {
        return childs;
    }

    public void setChilds(List<MenuVo> childs) {
        this.childs = childs;
    }
}
