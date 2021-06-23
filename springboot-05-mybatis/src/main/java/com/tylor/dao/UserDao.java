package com.tylor.dao;

import com.tylor.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao {

    List<User> getUserList();

    User getUserById(Integer id);

    void saveUser(User user);

    void updateUser(Map<String, Object> map);

    void deleteUser(Integer id);

}
