package com.qfedu.shiroadmin.dao;

import com.qfedu.shiroadmin.entity.SysPermission;

import java.util.List;

public interface SysPermissionMapper extends BaseDao<SysPermission>{
    int deleteById(Integer id);

    int insert(SysPermission record);

    SysPermission selectById(Integer id);

    int updateByIdKeySelective(SysPermission record);

    List<SysPermission> selectByLevel(int level);
    List<SysPermission> selectAllPerms(int type);



}