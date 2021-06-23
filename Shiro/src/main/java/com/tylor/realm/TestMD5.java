package com.tylor.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

public class TestMD5 {
    public static void main(String[] args) {
        //创建安全管理器
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //设置MD5加密
        MD5CustomRealm md5CustomRealm = new MD5CustomRealm();
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        md5CustomRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        //设置Realm
        defaultSecurityManager.setRealm(md5CustomRealm);
        //配置安全工具类
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        //合成令牌
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("tylor","123");
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        //授权
        if (subject.isAuthenticated()) {
            //1.基于角色的访问控制
            //验证单个角色
            System.out.println(subject.hasRole("admin"));
            System.out.println(subject.hasRole("a"));
            //验证拥有多个角色
            System.out.println(subject.hasAllRoles(Arrays.asList("admin", "user")));
            System.out.println(subject.hasAllRoles(Arrays.asList("admin", "a")));
            //验证一组角色中，拥有哪些
            boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "user" ,"super"));
            for (Boolean bool : booleans) {
                System.out.println(bool);
            }
            System.out.println("==========================");
            //2.基于资源的访问控制
            //验证拥有单个操作权限
            System.out.println(subject.isPermitted("user:update:01"));
            //验证拥有多个操作权限
            System.out.println(subject.isPermittedAll("admin:create:01", "super:update:02"));
            //验证一组操作权限中，拥有哪些
            boolean[] permitted = subject.isPermitted("user:*:01", "super:*:02");
            for (Boolean bool : permitted) {
                System.out.println(bool);
            }
        }
    }
}
