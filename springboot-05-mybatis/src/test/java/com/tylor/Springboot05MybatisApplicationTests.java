package com.tylor;

import com.tylor.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {

	@Autowired
	UserDao userDao;

	@Test
	void contextLoads() {
//		List<User> userList = userDao.getUserList();
//		System.out.println(userList);
//
//		User user = userDao.getUserById(4);
//		System.out.println(user);
//
//		User addUser = new User();
//		addUser.setId(6);
//		addUser.setName("tylor");
//		addUser.setPwd("123");
//		userDao.saveUser(addUser);
//		System.out.println(addUser);

//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "666");
//		map.put("id", 0);
//		userDao.updateUser(map);

		userDao.deleteUser(0);
	}

}
