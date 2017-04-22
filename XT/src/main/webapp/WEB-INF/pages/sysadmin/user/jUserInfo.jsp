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
		<td>用户昵称:</td>
		<td>${user.username}</td>
		<td>用户密码</td>
		<td>${user.password}</td>
	</tr>
	
	<tr class=  "odd">
		<td>用户名:</td>
		<td>${user.userInfo.name}</td>
		<td>性别:</td>
		<td>
			${user.userInfo.gender}
		</td>
	</tr>
	<tr class=  "odd">
		<td>上级部门</td>
		<td>
			${user.dept.deptName}
		</td>
		<td>上级领导:</td>
		<td>
			${user.userInfo.manager.name}
		</td>
	</tr>
	
	<tr class=  "odd">
		<td>身份证号码:</td>
		<td>${user.userInfo.cardNo}</td>
		<td>工资:</td>
		<td>${user.userInfo.salary}</td>
	</tr>
	
	<tr class=  "odd">
		<td>加入日期</td>
		<td>
			<fmt:formatDate value="${user.userInfo.joinDate}" pattern="yyyy-MM-dd"/>
		</td>
		<td>生日</td>
		<td>
			<fmt:formatDate value="${user.userInfo.birthday}" pattern="yyyy-MM-dd"/>
		</td>
	</tr>
	<tr class=  "odd">
		<td>电话:</td>
		<td>
			${user.userInfo.telephone}
		</td>
		<td>等级:</td>
		<td>
			<c:if test="${user.userInfo.userLevel==1}">总经理</c:if>
			<c:if test="${user.userInfo.userLevel==2}">副总</c:if>
			<c:if test="${user.userInfo.userLevel==3}">项目经理</c:if>
			<c:if test="${user.userInfo.userLevel==4}">普通用户</c:if>
		</td>
	</tr>
	<tr class=  "odd">
		<td>岗位:</td>
		<td>
			${user.userInfo.station}
		</td>
		
		<td>排序号:</td>
		<td>
			${user.userInfo.orderNo }
		</td>
	</tr>
	
	<tr class=  "odd">
		<td>描述</td>
		<td colspan="3">
			<textarea style = "width:100%;height:100px;" name = "userInfo.remark" readonly = "readonly" >${user.userInfo.remark}</textarea>
		</td>
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

