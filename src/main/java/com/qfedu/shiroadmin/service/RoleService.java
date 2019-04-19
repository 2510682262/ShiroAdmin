package com.qfedu.shiroadmin.service;

import com.qfedu.shiroadmin.common.vo.ResultVo;
import com.qfedu.shiroadmin.entity.SysRole;

public interface RoleService {

    ResultVo selectAll();

    ResultVo addRole(SysRole role);




}
