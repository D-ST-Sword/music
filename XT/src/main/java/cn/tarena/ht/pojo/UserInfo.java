package cn.tarena.ht.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserInfo extends BaseEntity{
	 /*
	  * USER_INFO_ID         VARCHAR2(40)         not null,
   NAME                 VARCHAR2(20),
   CARD_NO              VARCHAR2(20),
   MANAGER_ID           VARCHAR2(40),
   JOIN_DATE            TIMESTAMP,
   SALARY               NUMERIC(8, 2),
   BIRTHDAY             TIMESTAMP,
   GENDER               CHAR(1),
   STATION              VARCHAR2(20),
   TELEPHONE            VARCHAR2(100),
   USER_LEVEL           CHAR(1),
   REMARK               VARCHAR2(600),
   ORDER_NO             INT,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   UPDATE_BY            VARCHAR2(40)S,
   UPDATE_TIME          TIMESTAMP,
	  */
	private UserInfo manager;
	
	private String userInfoId;
	private String name;
	private String cardNo;
	private Date joinDate;
	private BigDecimal salary;
	private Date birthday;
	private String gender;
	private String station;
	private String telephone;
	private String userLevel;//4-普通用户3-部门经理2-副总1-总经理
	private String remark;
	private int orderNo;
	public UserInfo getManager() {
		return manager;
	}
	public void setManager(UserInfo manager) {
		this.manager = manager;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getRemark() {
		return remark;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	
	@Override
	public String toString() {
		return "UserInfo [manager=" + manager + ", userInfoId=" + userInfoId + ", name=" + name + ", cardNo=" + cardNo
				+ ", joinDate=" + joinDate + ", salary=" + salary + ", birthday=" + birthday + ", gender=" + gender
				+ ", station=" + station + ", telephone=" + telephone + ", userLevel=" + userLevel + ", remark="
				+ remark + ", orderNo=" + orderNo + "]";
	}
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	
}
