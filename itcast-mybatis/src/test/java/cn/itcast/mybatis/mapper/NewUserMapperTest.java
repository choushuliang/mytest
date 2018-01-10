package cn.itcast.mybatis.mapper;

import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.mybatis.pojo.User;

public class NewUserMapperTest {

	private NewUserMapper newUserMapper;

	@Before
	public void setUp() throws Exception {
		// 加载配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder Builder = new SqlSessionFactoryBuilder();
		// 创建SqlSessionFactory
		SqlSessionFactory sessionFactory = Builder.build(inputStream);
		// 创建SqlSession
		// 参数是 是否自动提交 如果为true 表示自动提交事务
		SqlSession sqlSession = sessionFactory.openSession(true);
		// 获取UserMapper
		this.newUserMapper = sqlSession.getMapper(NewUserMapper.class);
	}

	/**
	 * 
	 */
	@Test
	public void testSelectOne() {
		User user = new User();
		user.setId(1l);
		User result = this.newUserMapper.selectOne(user);

		System.out.println(result);
	}

	@Test
	public void testSelect() {
		User param = new User();
		param.setSex(1);

		// 查询所有数据参数为null
		List<User> list = this.newUserMapper.select(param);

		for (User user : list) {
			System.out.println(user);
		}

	}

	@Test
	public void testSelectCount() {

		User param = new User();
		param.setSex(1);

		// 查询所有数据参数为null
		int count = this.newUserMapper.selectCount(null);
		System.out.println(count);
	}

	@Test
	public void testSelectByPrimaryKey() {
		User user = this.newUserMapper.selectByPrimaryKey(1l);
		System.out.println(user);
	}

	@Test
	public void testInsert() {

		User user = new User();
		user.setUserName("caocao1");
		user.setName("曹操");
		user.setSex(1);

		this.newUserMapper.insert(user);

		System.out.println(user);
	}

	@Test
	public void testInsertSelective() {
		User user = new User();
		user.setUserName("caocao");
		user.setName("曹操");
		user.setSex(1);

		this.newUserMapper.insertSelective(user);

		System.out.println(user);

	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectCountByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void TestQueryUserByPage() {
		Map<String, Integer> param = new HashMap<>();

		param.put("page", 0);
		param.put("rows", 2);
		
		List<User> list = this.newUserMapper.queryUserByPage(param);
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testQueryUserByPageHelper(){
		//第一个参数是从哪一页开始，第二个参数是每页显示多少条数据
		PageHelper.startPage(1, 5);
		
		List<User> list = this.newUserMapper.select(null);
		
		for (User user : list) {
			System.out.println(user);
		}
		
		//分页信息使用pageInfo
		PageInfo<User> pageInfo=new PageInfo<>(list);
		
		System.out.println(pageInfo.getPages());
		System.out.println(pageInfo.getTotal());
		
	} 
	
	
}
