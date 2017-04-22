package cn.tarena.ht.pojo;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;


public class Role extends BaseEntity{
	/*
	 * ROLE_ID              VARCHAR2(40)         not null,
   NAME                 VARCHAR2(30),
   REMARKS              VARCHAR2(100),
   ORDER_NO             INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   UPDATE_BY            VARCHAR2(40),
   UPDATE_TIME          TIMESTAMP,
	 */
	@NotEmpty(message="roleId不能为空")
	private String roleId;
	@NotEmpty(message="name不可以为空")
	private String name;
	private String remarks;
	private Integer orderNo;
	
	private boolean checked;
	
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", remarks=" + remarks + ", orderNo=" + orderNo
				+ ", roleAndUserList=" + "]";
	}
	//给JSON封装数据的时候提供id
	public String getId(){
		return roleId;
	}
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	
	
	
}
