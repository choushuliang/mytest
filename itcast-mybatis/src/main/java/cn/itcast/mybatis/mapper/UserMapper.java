package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.User;

public interface UserMapper {

	/**
	 * 根据id查询用户
	 */
	public User queryUserById(Long id);

	/**
	 * 新增
	 */
	public void saveUser(User user);

	/**
	 * 更新
	 */
	public void updateUserById(User user);

	/**
	 * 根据id删除
	 */
	public void deleteUserById(Long id);
}
