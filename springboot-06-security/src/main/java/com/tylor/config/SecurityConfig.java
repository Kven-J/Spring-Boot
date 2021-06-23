package com.tylor.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @Author Chang
     * @Description //授权
     * @Date 22:50 2021/4/7
     * @Param [http]
     * @return void
     **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        //首页所有人可以访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/views/level1/**").hasRole("vip1")
                .antMatchers("/views/level2/**").hasRole("vip2")
                .antMatchers("/views/level3/**").hasRole("vip3");

        //开启自动配置的登录功能
        //login请求来到登录页
        //login?error重定向到登录页
        http.formLogin().loginPage("/toLogin").usernameParameter("name").passwordParameter("pwd").loginProcessingUrl("/login");

        http.csrf().disable();

        //开启自动配置的注销功能
        //logout注销请求
        http.logout().logoutSuccessUrl("/toLogin");

        http.rememberMe().rememberMeParameter("remember");
    }

    /**
     * @Author Chang
     * @Description //认证
     * @Date 22:51 2021/4/7
     * @Param [auth]
     * @return void
     **/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中定义
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
                withUser("tylor").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2","vip3")
                .and()
                .withUser("root1").password(new BCryptPasswordEncoder().encode("123")).roles("vip1")
                .and()
                .withUser("root2").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2");
    }

}
