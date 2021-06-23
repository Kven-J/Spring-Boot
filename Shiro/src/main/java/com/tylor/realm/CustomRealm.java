package com.tylor.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {

    /**
     * @Author Chang
     * @Description //授权
     * @Date 15:08 2021/4/25
     * @Param [principals]
     * @return org.apache.shiro.authz.AuthorizationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


    /**
     * @Author Chang
     * @Description //认证
     * @Date 15:08 2021/4/25
     * @Param [token]
     * @return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String)token.getPrincipal();
        if ("tylor".equals(principal)) {
            //参数1：返回数据库中正确的用户名
            //参数2：返回数据库中正确密码
            //参数3：提供当前realm的名字
            return new SimpleAuthenticationInfo(principal, "123", this.getName());
        }
        return null;
    }

}
