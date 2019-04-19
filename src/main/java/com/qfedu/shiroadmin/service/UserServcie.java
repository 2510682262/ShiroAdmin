package com.qfedu.shiroadmin.service;

import com.qfedu.shiroadmin.common.vo.PagePermissionVo;
import com.qfedu.shiroadmin.common.vo.PageVo;
import com.qfedu.shiroadmin.common.vo.ResultVo;
import com.qfedu.shiroadmin.entity.SysPermission;
import com.qfedu.shiroadmin.entity.SysUser;

import java.util.List;

public interface UserServcie {

    // 新增
    ResultVo save(SysUser user, int id);

    // 查询分页
    PageVo<SysUser> queryPage(int page, int limit);

    // 登录
    ResultVo login(String name, String  password);

    // 分配角色
    ResultVo changeRole(int uid, List<Integer> rids);

    // 重置密码
    ResultVo changePasswrod(int uid, String passwrod);

    // 查询用户所有的所有权限
    List<String> queryPerms(int uid);

    // 查询左侧菜单
    ResultVo queryMenu(Integer uid);

    // 查询所有用户信息
    PagePermissionVo<SysUser> queryAll(int page, int limit);

    // 查询用户数量
    ResultVo queryAllCount();

    ResultVo queryUr(int id);
}
