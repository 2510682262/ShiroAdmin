package com.qfedu.shiroadmin.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

    public static boolean checkPermission(String perm){
        Subject subject = SecurityUtils.getSubject ();
        return subject.isPermitted (perm);
    }

}
