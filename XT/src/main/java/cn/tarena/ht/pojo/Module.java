package cn.tarena.ht.pojo;

public class Module extends BaseEntity{
	/*
	 * MODULE_ID            VARCHAR2(40)         not null,
   PARENT_ID            VARCHAR2(40),
   NAME                 VARCHAR2(100),
   CTYPE                INT,
   STATE                INT,
   ORDER_NO             INT,
   REMARK               VARCHAR2(100),
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          TIMESTAMP,
   UPDATE_BY            VARCHAR2(40),
   UPDATE_TIME          TIMESTAMP,
   constraint PK_MODULE_P primary key (MODULE_ID)
	 */
	private String moduleId;
	private Module parentModule; //上级模块
	private String name;
	private Integer ctype;//1.主菜单,2.左侧菜单,3.按钮
	private Integer state;
	private Integer orderNo;
	private String remark;
	private boolean checked;
	//设置id
	public String getId(){
		return moduleId;
	}
	//设置上级模块id
	public String getpId(){
		if(parentModule!=null){
			return parentModule.getId();
		}
		return "";
	}
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
