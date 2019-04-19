package com.qfedu.shiroadmin.controller;

import com.qfedu.shiroadmin.common.vo.ResultVo;
import com.qfedu.shiroadmin.entity.SysRole;
import com.qfedu.shiroadmin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("roleAll.do")
    public ResultVo selectAll(){

        return roleService.selectAll ();

    }

    @GetMapping("add.do")
    public ResultVo add(SysRole role){

        return roleService.addRole (role);

    }
}
