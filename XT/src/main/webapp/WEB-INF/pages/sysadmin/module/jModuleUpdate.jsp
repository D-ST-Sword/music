<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>模块更新</title>
</head>

<body>
	<form name="icform" method="post">

		<div id="menubar">
			<div id="middleMenubar">
				<div id="innerMenubar">
					<div id="navMenubar">
						<ul>
							<li id="view"><a href="#"
								onclick="formSubmit('update','_self');this.blur();">提交</a></li>
							<li id="view"><a href="#"
								onclick="window.history.back();this.blur();">返回</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="textbox-title">
			<img src="../../staticfile/skin/default/images/icon/currency_yen.png" />
			模块更新
		</div>
		<div>
			<div class="eXtremeTable">
				<table id="ec_table" class="tableRegion" width="98%">
					<tr class="odd">
						<input type= "hidden" name = "moduleId" value = "${module.moduleId}">
						<td>模块名称:</td>
						<td><input type="text" name="name" value = "${module.name}"></td>
					</tr>

					<tr class="odd">
						<td>模块级别:</td>
						<td><select name="ctype">
								<option value="1" style="width: 121px" <c:if test="${module.ctype ==1 }">selected = "selected"</c:if>>主菜单</option>
								<option value="2" style="width: 121px" <c:if test="${module.ctype ==2 }">selected = "selected"</c:if>>左侧菜单</option>
								<option value="3" style="width: 121px" <c:if test="${module.ctype ==3 }">selected = "selected"</c:if>>按钮</option>
						</select></td>
					</tr>
					<tr class="odd">
						<td>上级模块</td>
						<td><select name="parentModule.moduleId">
								<option value="" style="width: 121px">无上级模块</option>
								<c:forEach items="${parentList}" var="p">
									<c:if test="${p.moduleId!=module.moduleId}">
										<option value="${p.moduleId}" style="width: 121px" <c:if test="${p.moduleId==module.parentModule.moduleId}">selected = "selected"</c:if>>${p.name}</option>
									</c:if>
								</c:forEach>
						</select></td>
					</tr>

					<tr class="odd">
						<td>序号:</td>
						<td><input type="text" name="orderNo" value="${module.orderNo}"></td>
					</tr>

					<tr class="odd">
						<td>备注</td>
						<td><textarea style="width: 100%; height: 100px;"
								name="remark"> ${module.remark}</textarea></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>

