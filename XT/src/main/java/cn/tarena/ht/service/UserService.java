package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;

public interface UserService {

	List<User> findAll();

	void updateState(String[] userIds,int state);

	void deleteUsers(String[] userIds);

	List<UserInfo> findAllManager();

	void saveUser(User user);

	User findOne(String userId);

	List<UserInfo> findMananger(String userId);
	
	
	void insertUserRole(String userId, String[] roleIds);

	void updateUser(User user);
	
	/**
	 * 检查用户密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	boolean checku_p(String username, String password);

	String findUserIdByu_p(String username, String password);

	boolean checkUsername(String username);

	User findUserByUsername(String username);

	User findUserByu_p(String username, String password);

	List<String> findPrivilegeList(String userId);

}
