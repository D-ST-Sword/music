<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户列表</title>
	<script src="${ctx}/staticfile/js/datepicker/jquery-1.6.2.js"></script>
	<script src="${ctx}/staticfile/components/pngfix/DD_belatedPNG.js"></script>
	<script type="text/javascript">
		alert(1);
		$(function(){
			$("#username").blur(function(){
				var $username = $("#username").val();
				alert($username);
				$("#username").load("check.action",{"username":$username});
			})
			
		})
	</script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit('save','_self');this.blur();">提交</a></li>
	<li id="view"><a href="#" onclick="window.history.back();this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户新增
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<!-- 
	private UserInfo manager;
	
	private String UserInfoId;
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
	
	private String userId;
	private String username;
	private String password;
	private int state;
	private Dept dept;
	private UserInfo userInfo;
	 -->
	<tr class=  "odd">
		
		<td>用户昵称:</td>
		<td><input type = "text" name = "username" id = "username"></td>
		
		<td>用户密码</td>
		<td><input type = "password" name = "password"/></td>
	</tr>
	
	<tr class=  "odd">
		<td>用户名:</td>
		<td><input type = "text" name = "userInfo.name"/></td>
		<td>性别:</td>
		<td>
			<input type = "radio" name = "userInfo.gender" value= "男" >男
			<input type = "radio" name = "userInfo.gender" value= "女" >女
		</td>
	</tr>
	<tr class=  "odd">
		<td>上级部门</td>
		<td>
			<select name = "dept.deptId">
				<c:forEach items="${deptList}" var="dept">
					<option value = "${dept.deptId}"> ${dept.deptName}</option>
				</c:forEach>
			</select>
		</td>
		<td>上级领导:</td>
		<td>
			<select name = "userInfo.manager.userInfoId">
				<c:forEach items="${ managerList}" var="manager">
					<option value = "${manager.userInfoId}"> ${manager.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	
	<tr class=  "odd">
		<td>身份证号码:</td>
		<td><input type = "text" name = "userInfo.cardNo"></td>
		<td>工资:</td>
		<td><input type = "text" name = "userInfo.salary"></td>
	</tr>
	
	<tr class=  "odd">
		<td>加入日期</td>
		<td>
			<input type="text" style="width:90px;" name="userInfo.joinDate"
	   		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
		</td>
		<td>生日</td>
		<td>
			<input type="text" style="width:90px;" name="userInfo.birthday"
	   		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
		</td>
	</tr>
	<tr class=  "odd">
		<td>电话:</td>
		<td>
			<input type = "text" name = "userInfo.telephone">
		</td>
		<td>等级:</td>
		<td>
			<select name = "userInfo.userLevel">
				<option value = "1">总经理</option>
				<option value = "2">副总</option>
				<option value = "3">项目经理</option>
				<option value = "4">普通用户</option>
			</select>
		</td>
	</tr>
	<tr class=  "odd">
		<td>岗位:</td>
		<td>
			<input type="text" name="userInfo.station"/>
		</td>
		
		<td>排序号:</td>
		<td>
			<input type="text" name="userInfo.orderNo"/>
		</td>
	</tr>
	
	<tr class=  "odd">
		<td>描述</td>
		<td colspan="3">
			<textarea style = "width:100%;height:100px;" name = "userInfo.remark"></textarea>
		</td>
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

