<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>部门列表</title>
	<!-- 引入JQuery核心类库 -->
	<!--  
	<script type="text/javascript" src = "${CTX}/staticfile/js/jquery-1.6.2.js"></script>
	<script type="text/javascript">
		$(function(){
			
		})
	</script>
	-->
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
    部门新增
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >

	<tr class=  "odd">
		<td>部门编号</td>
		<td><input type = "text" name = "deptId" value = "${deptInfo.deptId}"></td>
	</tr>
	<tr class=  "odd">
		<td>部门名称</td>
		<td><input type = "text" name = "deptName" value = "${deptInfo.deptName}"></td>
	</tr>
	<tr class=  "odd">
		<td>上级部门</td>
		<td>
			<input type = "text" name = "deptName" value = "${deptInfo.parentDept.deptName}">
		</td>
	</tr>
	<tr class=  "odd">
		<td>状态:</td>
		<td>
			<c:if test="${deptInfo.state==1}"><font color="green">启用</font></c:if>
			<c:if test="${deptInfo.state==0}"><font color="red">停用</font></c:if>
		</td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

