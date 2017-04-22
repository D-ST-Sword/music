package music.pojo;

import java.util.Date;
import java.util.List;

public class User extends BaseEntity {
	
	private String userId;//用户名
	private String gradeId;//用户等级
	private String name;//用户名
	private String password;
	private String userImg;
	private String gender;
	private Date createTime;
	private Integer level;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", gradeId=" + gradeId + ", name=" + name + ", password=" + password
				+ ", userImg=" + userImg + ", gender=" + gender + ", createTime=" + createTime + ", level=" + level
				+ "]";
	}
	
	   
}
