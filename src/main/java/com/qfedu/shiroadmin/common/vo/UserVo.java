package com.qfedu.shiroadmin.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserVo {

    private Integer id;

    private String name;

    private String roles;

    private String flagmsg;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getFlagmsg() {
        return flagmsg;
    }

    public void setFlagmsg(String flagmsg) {
        this.flagmsg = flagmsg;
    }

    public Date getCreateTime() {
        return createtime;
    }

    public void setCreateTime(Date createTime) {
        this.createtime = createTime;
    }
}
