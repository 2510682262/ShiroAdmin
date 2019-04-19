package com.qfedu.shiroadmin.realm;

import com.qfedu.shiroadmin.entity.SysUser;
import com.qfedu.shiroadmin.service.UserServcie;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
* 自定义用户的Realm类
* 实现登录许可方法和用户授权方法
* */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServcie userServcie;

    // 授权   查询登录用户的所有权限，并返回
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 1、获取登录用户
        SysUser user = (SysUser) SecurityUtils.getSubject ().getSession ().getAttribute ("user");
        // 2、查询对应的权限
        List<String> perms = userServcie.queryPerms (user.getId ());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo ();
        // 3、设置权限到指定对象中
        authorizationInfo.addStringPermissions (perms);

        return authorizationInfo;
    }

    // 认证   登录许可，标记是否登录成功
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取传递的令牌
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        if (userToken.getUsername () != null){

            // 创建认证信息 参数说明：1、用户名 2、密码 3、Real的名字
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo (userToken.getUsername (),userToken.getPassword (),getName ());
            return authenticationInfo;

        }
        return null;
    }
}
