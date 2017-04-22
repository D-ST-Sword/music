<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>角色新增</title>
</head>

<body>
	<form name="icform" method="post">

		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>
							<li id="view"><a href="#"
								onclick="window.history.back();this.blur();">返回</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			角色新增
		</div>
		<div>
			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tr class="odd">
						<td>角色名称:</td>
						<td>${role.name}</td>
					</tr>
					<tr>
						<td>排序号:</td>
						<td>${role.orderNo}</td>
					</tr>
					<tr class="odd">
						<td>备注信息:</td>
						<td>
							<textarea style="width: 100%; height: 100px;" name="remarks" readonly = "readonly">${role.remarks}</textarea>
						</td>

					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>

