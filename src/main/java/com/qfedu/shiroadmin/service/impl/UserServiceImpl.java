package com.qfedu.shiroadmin.service.impl;

import com.qfedu.shiroadmin.common.util.ResultUtil;
import com.qfedu.shiroadmin.common.util.ShiroUtil;
import com.qfedu.shiroadmin.common.vo.*;
import com.qfedu.shiroadmin.dao.SysUserMapper;
import com.qfedu.shiroadmin.dao.SysUserRoleMapper;
import com.qfedu.shiroadmin.entity.SysPermission;
import com.qfedu.shiroadmin.entity.SysUser;
import com.qfedu.shiroadmin.entity.SysUserRole;
import com.qfedu.shiroadmin.service.UserServcie;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserServcie {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public ResultVo save(SysUser user, int rid) {
        int insert = userMapper.insert (user);
        System.out.println (insert);
        // 新增用户角色
        SysUserRole userRole = new SysUserRole ();
        userRole.setRid (rid);
        userRole.setUid (user.getId ());
        userRoleMapper.insert (userRole);

        return ResultUtil.exec (true,"OK",null);
    }

    @Override
    public PageVo<SysUser> queryPage(int page, int limit) {
        return null;
    }

    @Override
    public ResultVo login(String name, String password) {

        SysUser user = userMapper.selectByName (name);

        if (user != null){
            if (user.getPassword ().equals (password)){
                return ResultUtil.exec (true,"OK",user);
            }
        }
        return ResultUtil.exec (false,"用户名或密码不正确",null);
    }

    @Override
    public ResultVo changeRole(int uid, List<Integer> rids) {

        userRoleMapper.deleteByUid (uid);

        // 批量添加
        userRoleMapper.insertBatch (uid,rids);

        return ResultUtil.exec (true,"OK",null);
    }

    @Override
    public ResultVo changePasswrod(int uid, String passwrod) {

        return ResultUtil.exec (userMapper.updateByIdPassword (uid,passwrod) > 0,"OK",null);
    }

    @Override
    public List<String> queryPerms(int uid) {
        return userMapper.selectByUidPerms (uid);
    }

    @Override
    public ResultVo queryMenu(Integer uid) {
        List<SysPermission> permissions = userMapper.selectByUidMenu (uid);
        List<MenuVo> rootMenu = new ArrayList<> ();
        for(SysPermission p : permissions){
            if (p.getLevel () == 1){
                MenuVo oneMenu = new MenuVo ();
                BeanUtils.copyProperties (p,oneMenu);
                oneMenu.setChilds (new ArrayList<> ());
                rootMenu.add (oneMenu);
            } else {
                if (p.getLevel () == 2){
                    MenuVo parent = getParent (p.getParentid (), rootMenu);
                    if (parent != null){
                        MenuVo childMenu = new MenuVo ();
                        BeanUtils.copyProperties (p,childMenu);
                        parent.getChilds ().add (childMenu);
                    }
                }
            }
        }

        return ResultUtil.exec (true,"OK",rootMenu);
    }

    @Override
    public PagePermissionVo<SysUser> queryAll(int page, int limit) {
        /*List<SysUser> list = userMapper.selectAll (page, limit);
        List<UserRoleVo> userRoleVos = userMapper.selectByUidRole ();
        List<UserVo> userVos = new ArrayList<> ();
        for (SysUser user : list){
            UserVo userVo = new UserVo ();
            BeanUtils.copyProperties (user,userVo);
            userVo.setCreateTime (user.getCreatetime ());
            userVo.setFlagmsg (getFlag (user.getFlag ()));
            userVo.setRoles (getRoles (userRoleVos,user.getId ()));
            userVos.add (userVo);
        }*/
        HashMap<String,Object> map = new HashMap<> ();
        map.put ("index",(page-1) * limit);
        map.put ("count",limit);
        return ResultUtil.exec (page,limit,userMapper.selectAllCount (),
                ShiroUtil.checkPermission ("user:update"),ShiroUtil.checkPermission ("user:del"),
                userMapper.selectPage (map)
                );
    }

    @Override
    public ResultVo queryAllCount() {

        Integer integer = userMapper.selectAllCount ();

        return ResultUtil.exec (true,"OK",integer);
    }

    @Override
    public ResultVo queryUr(int id) {

        return ResultUtil.exec (true,"OK",userMapper.selectByUr (id));
    }

    private MenuVo getParent(int id,List<MenuVo> rootMenu){
        for (MenuVo m : rootMenu){
            if (m.getId () == id){
                return m;
            }
        }
        return null;
    }

    private String getFlag(int flag){
        String res = "";
        switch (flag){
            case 1:
                res = "有效";
                break;
            case 2:
                res = "冻结";
                break;
            case 3:
                res = "无效";
                break;
        }
        return res;
    }

    private String getRoles(List<UserRoleVo> list, Integer uid){
        StringBuffer buffer = new StringBuffer ();
        for (UserRoleVo userRoleVo : list){
            if (userRoleVo.getUid ().equals (uid)){
                buffer.append (userRoleVo.getName () + ",");
            }
        }
        if (buffer.lastIndexOf (",") > 0){
            buffer.deleteCharAt (buffer.length () - 1);
        }

        return buffer.toString ();

    }}
