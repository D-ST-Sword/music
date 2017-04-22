package cn.tarena.ht.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}

	@Override
	public void updateState(String[] userIds,int state) {
		userMapper.updateState(userIds,state);
		
	}

	@Override
	public void deleteUsers(String[] userIds) {
		//删除两个表,需要先删除从表,再删除主表
		//先删除UserInfo表信息
		userInfoMapper.deleteUserInfos(userIds);
		
		//删除主表User表信息
		userMapper.deleteUsers(userIds);
		
	}

	@Override
	public List<UserInfo> findAllManager() {
		return userInfoMapper.findAllManager();
	}
	
	/**
	 * 新增用户
	 */
	@Override
	public void saveUser(User user) {
		//获取用户信息对象
		UserInfo userInfo = user.getUserInfo();
		//创建用户id
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		userInfo.setUserInfoId(id);
		
		//创建用户默认开启状态为开启
		user.setState(1);
		
		
		//1.新增主表
		userMapper.saveUser(user);
		//2.新增从表
		userInfoMapper.saveUserInfo(userInfo);
		
	}
	
	@Override
	public void updateUser(User user) {
		user.setUpdateTime(new Date());
		user.getUserInfo().setUpdateTime(new Date());
		userInfoMapper.updateUserInfo(user.getUserInfo());
		userMapper.updateUser(user);
	}
	
	/**
	 * 查询指定id的一个user对象
	 */
	@Override
	public User findOne(String userId) {
		return userMapper.findOne(userId);
	}
	
	/**
	 * 寻找指定id的上级领导
	 */
	@Override
	public List<UserInfo> findMananger(String userInfoId) {
		return userInfoMapper.findManager(userInfoId);
	}

	@Override
	public void insertUserRole(String userId, String[] roleIds) {
		//将数据插入到role_user_p中
		userMapper.deleteUserRole(userId);
		for(String roleId:roleIds){
			userMapper.saveUserRole(userId, roleId);
		}
		
	}

	@Override
	public boolean checku_p(String username, String password) {
		boolean flag = false;
		
		if(userMapper.checku_p(username,password)!=null){
			flag = true;
		}
		return flag;
	}

	@Override
	public String findUserIdByu_p(String username, String password) {
		User user = userMapper.checku_p(username, password);
		return user.getUserId();
	}

	@Override
	public boolean checkUsername(String username) {
		if(userMapper.checkUsername(username)==null){
			return true;
		}
		return false;
	}

	@Override
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}

	@Override
	public User findUserByu_p(String username, String password) {
		return userMapper.checku_p(username, password);
	}

	@Override
	public List<String> findPrivilegeList(String userId) {
		
		return userMapper.findPrivilegeList(userId);
	}

	
}

