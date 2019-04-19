package com.qfedu.shiroadmin.controller;

import com.qfedu.shiroadmin.common.sysconst.SystemCon;
import com.qfedu.shiroadmin.common.vo.PagePermissionVo;
import com.qfedu.shiroadmin.common.vo.ResultVo;
import com.qfedu.shiroadmin.entity.SysUser;
import com.qfedu.shiroadmin.service.UserServcie;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServcie userServcie;

    @PostMapping("userlogin.do")
    public ResultVo login(String name, String password){
        ResultVo resultVo = userServcie.login (name,password);

        if (resultVo.getCode () == SystemCon.OK){
            // 需要告知Shiro
            // 1、创建登录令牌
            UsernamePasswordToken token = new UsernamePasswordToken (name,password);
            // 2、获取主题
            Subject subject = SecurityUtils.getSubject ();
            // 3、在session设置当前的登录用户
            subject.getSession ().setAttribute ("user",resultVo.getData ());
            // 4、发起认证 ---会调用Shiro对应的Realm的认证方法
            subject.login (token);
        }
        return resultVo;
    }

    @PostMapping("signUp.do")
    public ResultVo signUp(SysUser user,Integer rid){

        ResultVo resultVo = userServcie.save (user, rid);

        return resultVo;

    }

    @GetMapping("usermenu.do")
    public ResultVo getMenu(){
        SysUser user = (SysUser) SecurityUtils.getSubject ().getSession ().getAttribute ("user");

        return userServcie.queryMenu (user.getId ());
    }

    @GetMapping("userAll.do")
    public PagePermissionVo<SysUser> all(Integer page, Integer limit){

        return userServcie.queryAll (page, limit);
    }

    @GetMapping("userAllCount.do")
    public ResultVo allCount(){

        return userServcie.queryAllCount ();
    }

    @GetMapping("userrole.do")
    public ResultVo queryur(int id){

        return userServcie.queryAllCount ();
    }





}
