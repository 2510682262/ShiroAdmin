package com.qfedu.shiroadmin.service.impl;

import com.qfedu.shiroadmin.common.util.ResultUtil;
import com.qfedu.shiroadmin.common.vo.ResultVo;
import com.qfedu.shiroadmin.dao.SysRoleMapper;
import com.qfedu.shiroadmin.entity.SysRole;
import com.qfedu.shiroadmin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public ResultVo selectAll() {

        List<SysRole> sysRoles = roleMapper.selectAll ();

        return ResultUtil.exec (true,"OK",sysRoles);
    }

    @Override
    public ResultVo addRole(SysRole role) {

        SysRole sysRole = roleMapper.selectByName (role.getName ());

        if (!role.getName ().equals ("")){
            if (sysRole == null){
                roleMapper.insert (role);
                return ResultUtil.exec (true,"OK",null);
            } else {
                return ResultUtil.exec (false,"角色已存在，请不要重复添加",null);
            }
        }

        return ResultUtil.exec (false,"角色名不能为空",null);

    }
}
