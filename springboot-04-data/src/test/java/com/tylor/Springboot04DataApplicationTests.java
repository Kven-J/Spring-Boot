package com.tylor;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

	@Autowired
	@Qualifier("dataSource")
	DataSource dataSource;

	@Test
	void contextLoads() {
		//看一下默认数据源
		System.out.println(dataSource.getClass());
		Connection connection = null;
		try {
			//获得连接
			connection = dataSource.getConnection();
			System.out.println(connection);

             DruidDataSource dataSource = (DruidDataSource) this.dataSource;
             System.out.println(dataSource.getMaxActive());
             System.out.println(dataSource.getInitialSize());

			//关闭连接
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
