package cn.itcast.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.pojo.User;

public class UserMapperTest {
	
	private UserMapper userMapper;

	@Before
	public void setUp() throws Exception {
		//加载配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		//创建SqlSession
		//参数是 是否自动提交 如果为true  表示自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//获取UserMapper
		this.userMapper = sqlSession.getMapper(UserMapper.class);
		
	}

	@Test
	public void testQueryUserById() {
		User user = this.userMapper.queryUserById(1l);
		
		System.out.println(user);
	
	}

	@Test
	public void testSaveUser() {
		User user=new User();
		user.setName("关羽1");
		user.setUserName("guanyu1");
		user.setAge(19);
		
		this.userMapper.saveUser(user);
		System.out.println(user);
	}

	@Test
	public void testUpdateUserById() {
		User user =new User();
		user.setId(9l);
		user.setName("张飞");
		user.setUserName("zhangfei");
		user.setAge(18);
		
		this.userMapper.updateUserById(user);
	}

	@Test
	public void testDeleteUserById() {
		this.userMapper.deleteUserById(10l);
	}
}
