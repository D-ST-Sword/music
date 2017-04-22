package cn.tarena.ht.pojo;

import java.util.List;

public class User extends BaseEntity{
	
	private String userId;

	private String username;
	private String password;
	private int state;
	
	private Dept dept;
	private UserInfo userInfo;
	
	/*
	 * 用户和角色之间的多对多关系封装
	 */
	
	private List<RoleAndUser> roleAndUserList;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", state=" + state
				+ ", dept=" + dept + ", userInfo=" + userInfo + "]";
	}
	
	
	
	
}
