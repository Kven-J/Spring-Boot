package com.tylor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //1.创建安全管理器对象
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

        //2.给安全管理器设置Realm
        defaultSecurityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        //3.SecurityUtils 给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //4.获取Subject主体
        Subject subject = SecurityUtils.getSubject();

        //5.创建令牌  令牌 = Principal（用户名） + Credential（密码）
        UsernamePasswordToken token = new UsernamePasswordToken("tylor","123");
        try {
            System.out.println(subject.isAuthenticated());
            subject.login(token);//用户认证
            System.out.println(subject.isAuthenticated());
        } catch (UnknownAccountException uae) {
            uae.printStackTrace();//用户名错误
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException ice) {
            ice.printStackTrace();//密码错误
            System.out.println("密码错误");
        }
    }
}
