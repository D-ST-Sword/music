package cn.tarena.ht.pojo;


public class Dept extends BaseEntity {
	
	private String deptId;	//表示部门ID
	private Dept parentDept;//表示上级部门对象
	
	private String deptName;//部门名称	
	private int state; //部门状态
	
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", parentDept=" + parentDept + ", deptName=" + deptName + ", state=" + state
				+ "]";
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Dept getParentDept() {
		return parentDept;
	}
	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
