package com.qfedu.shiroadmin.dao;

import com.qfedu.shiroadmin.common.vo.PageVo;
import com.qfedu.shiroadmin.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteById(Integer id);

    int insert(SysRole record);

    SysRole selectById(Integer id);

    int updateBuId(SysRole role);

    Long selectCount();

    PageVo<SysRole> selectByPage(@Param ("index") int index, @Param ("limit") int limit);

    List<SysRole> selectAll();

    SysRole selectByName(String name);
}