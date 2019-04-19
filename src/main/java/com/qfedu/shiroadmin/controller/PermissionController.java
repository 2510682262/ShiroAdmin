package com.qfedu.shiroadmin.controller;

import com.qfedu.shiroadmin.common.util.ResultUtil;
import com.qfedu.shiroadmin.common.vo.ResultVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;

public class PermissionController {

    @GetMapping("permissioncheck.do")
    public ResultVo check(String permission){

        Subject subject = SecurityUtils.getSubject ();
        try {
            subject.checkPermission (permission);
            return ResultUtil.exec (true,"OK",null);
        } catch (AuthorizationException e) {
            e.printStackTrace ();
            return ResultUtil.exec (false,"ERROR",null);
        }
    }

}
