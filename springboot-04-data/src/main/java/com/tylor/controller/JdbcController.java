package com.tylor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询
    @GetMapping("/show")
    public List<Map<String, Object>> show(){
        String sql = "select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    //新增
    @GetMapping("/add")
    public String add(){
        String sql = "INSERT INTO mybatis.user(id, name, pwd) VALUES(5, '牛儿', '123') ";
        jdbcTemplate.execute(sql);
        return "add_success";
    }

    //修改
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id")int id){
        String sql = "update mybatis.user set pwd=? , name=? where id=" + id;
        System.out.println(sql);
        Object[] args = new Object[2];
        args[0] = "112233";
        args[1] = "牛二";
        jdbcTemplate.update(sql, args);
        return "update_success";
    }

    //删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        String sql = "DELETE FROM mybatis.user WHERE id=" + id;
        System.out.println(sql);
        jdbcTemplate.execute(sql);
        return "delete_success";
    }

}
