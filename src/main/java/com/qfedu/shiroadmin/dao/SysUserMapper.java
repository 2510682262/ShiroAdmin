package com.qfedu.shiroadmin.dao;

import com.qfedu.shiroadmin.common.vo.UserRoleVo;
import com.qfedu.shiroadmin.entity.SysPermission;
import com.qfedu.shiroadmin.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper extends BaseDao<SysUser>{

    int insert(SysUser record);

    SysUser selectById(Integer id);

    SysUser selectByName(String name);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByIdFlag(@Param ("id") int id, @Param ("flag") int flag);

    int updateByIdPassword(@Param ("id") int id, @Param ("password") String password);

    List<SysPermission> selectByUidMenu(Integer uid);

    List<String> selectByUidPerms(Integer uid);

    List<SysUser> selectAll(@Param ("page") int page, @Param ("limit") int limit);

    Integer selectAllCount();

    List<UserRoleVo> selectByUidRole();

    List<Integer> selectByUr(int id);

}