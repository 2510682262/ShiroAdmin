package com.qfedu.shiroadmin.dao;

import com.qfedu.shiroadmin.entity.SysRole;
import com.qfedu.shiroadmin.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface SysUserRoleMapper {

    int deleteById(Integer id);

    int deleteByUid(Integer uid);

    // 实现批量新增
    int insertBatch(@Param ("uid") Integer uid,@Param ("rids") List<Integer> rids);

    List<SysRole> selectByUid(Integer uid);

    int insert(SysUserRole userRole);

}