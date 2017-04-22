<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="formSubmit('update','_self');this.blur();">更新</a></li>
	<li id="view"><a href="#" onclick="window.history.back();this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户查看
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
		<input type = "hidden" name = "userId" value = "${user.userId}">
		<input type = "hidden" name = "userInfo.userInfoId" value = "${user.userInfo.userInfoId}">
		<td>用户昵称:</td>
		<td><input type = "text" name = "username" value = "${user.username}"/></td>
		<td>用户密码</td>
		<td><input type = "text" name = "password" value = "${user.password}"/></td>
	</tr>
	
	<tr class=  "odd">
		<td>用户名:</td>
		<td><input type = "text" name = "userInfo.name" value = "${user.userInfo.name}"/></td>
		<td>性别:</td>
		<td>
			<input type = "radio" name = "userInfo.gender" value = "男"
				<c:if test = "${user.userInfo.gender=='男' }">checked="checked"</c:if> 
			/>男
			<input type = "radio" name = "userInfo.gender" value = "女"
				<c:if test = "${user.userInfo.gender=='女'}">checked="checked"</c:if> 
			/>女
		</td>
	</tr>
	<tr class=  "odd">
		<td>所在部门</td>
		<td>
			<select name = "dept.deptId">
				<c:forEach items="${deptList}" var="d">
					<option value = "${d.deptId}" 
						<c:if test="${d.deptId==dept.deptId}">selected = "selected"</c:if>> 
						${d.deptName}
					</option>
				</c:forEach>
			</select>
		</td>
		<td>上级领导:</td>
		<td>
			<select name = "userInfo.manager.userInfoId">
				<option value = "">已最高领导</option>
				<c:forEach items="${ managerList}" var="manager">
					<option value = "${manager.userInfoId}"
						<c:if test = "${manager.userInfoId==userInfo.manager.userInfoId}">selected = "selected"</c:if>> 
						${manager.name}
					</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	
	<tr class=  "odd">
		<td>身份证号码:</td>
		<td><input type = "text" value = "${user.userInfo.cardNo}" name = "userInfo.cardNo"/></td>
		<td>工资:</td>
		<td><input type = "text" value = "${user.userInfo.salary}" name = "userInfo.salary"/></td>
	</tr>
	
	<tr class=  "odd">
		<td>加入日期</td>
		<td>
			<input type = "text" name = "userInfo.joinDate"
			value = "<fmt:formatDate value="${user.userInfo.joinDate}" pattern="yyyy-MM-dd"/>"
			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
			
		</td>
		<td>生日</td>
		<td>
			<input type = "text" name = "userInfo.birthday"
			value = "<fmt:formatDate value="${user.userInfo.birthday}" pattern="yyyy-MM-dd"/>"
			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
		</td>
	</tr>
	<tr class=  "odd">
		<td>电话:</td>
		<td>
			<input type = "text" value = "${user.userInfo.telephone}" name = "userInfo.telephone"/>
		</td>
		<td>等级:</td>
		<td>
			<select name = "userInfo.userLevel">
				<option value = "1" <c:if test="${user.userInfo.userLevel==1}">selected = "selected"</c:if>>总经理</option>
				<option value = "2" <c:if test="${user.userInfo.userLevel==2}">selected = "selected"</c:if>>副总</option>
				<option value = "3" <c:if test="${user.userInfo.userLevel==3}">selected = "selected"</c:if>>项目经理</option>
				<option value = "4" <c:if test="${user.userInfo.userLevel==4}">selected = "selected"</c:if>>普通用户</option>
			</select>
		</td>
	</tr>
	<tr class=  "odd">
		<td>岗位:</td>
		<td>
			<input type = "text" value = "${user.userInfo.station}" name = "userInfo.station"/>
		</td>
		
		<td>排序号:</td>
		<td>
			<input type = "text" value = "${user.userInfo.orderNo }" name = "userInfo.orderNo"/>
		</td>
	</tr>
	
	<tr class=  "odd">
		<td>描述</td>
		<td colspan="3">
			<textarea style = "width:100%;height:100px;" name = "userInfo.remark">${user.userInfo.remark}</textarea>
		</td>
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

