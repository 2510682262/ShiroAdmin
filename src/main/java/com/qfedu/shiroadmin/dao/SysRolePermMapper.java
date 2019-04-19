package com.qfedu.shiroadmin.dao;

import com.qfedu.shiroadmin.entity.SysPermission;
import com.qfedu.shiroadmin.entity.SysRolePerm;

import java.util.List;

public interface SysRolePermMapper {

    int deleteById(Integer id);

    int deleteByRid(Integer id);

    int insert(SysRolePerm record);

    List<SysPermission> selectByRid(Integer rid);

}