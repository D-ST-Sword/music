package cn.tarena.ht.pojo;

public class RoleAndUser {
	/*
   ROLE_ID              VARCHAR2(40),
   USER_ID              VARCHAR2(40)
	 */
	
	private String roleId;
	private String userId;
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RoleAndUser [roleId=" + roleId + ", userId=" + userId + "]";
	}
}
