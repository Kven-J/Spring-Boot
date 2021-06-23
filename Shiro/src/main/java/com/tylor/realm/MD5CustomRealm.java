package com.tylor.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Arrays;

public class MD5CustomRealm extends AuthorizingRealm {
    /**
     * @Author Chang
     * @Description //授权  缺陷：每验证一次权限就要查询一次数据库
     * @Date 0:28 2021/6/24
     * @Param [principals]
     * @return org.apache.shiro.authz.AuthorizationInfo
     **/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限check");
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //1.基于角色的访问控制
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addRole("user");
        simpleAuthorizationInfo.addRoles(Arrays.asList("a","b","c"));
        //2.基于资源的访问控制
        simpleAuthorizationInfo.addStringPermission("user:*");
        simpleAuthorizationInfo.addStringPermissions(Arrays.asList("admin:create:01","super:*:01"));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String)token.getPrincipal();
        if ("tylor".equals(principal)) {
            return new SimpleAuthenticationInfo(principal,"d023310873ceb9dc79bb5a51d1447e5e", ByteSource.Util.bytes("tylor*#"),this.getName());
        }
        return null;
    }
}
