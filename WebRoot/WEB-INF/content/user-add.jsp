<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>增加新用户</div>
	<s:form action="%{#request.contextPath}/user" method="post">
		<table>
			<tr>
				<th>名称</th>
				<td><s:textfield name="userName"/></td>
			</tr>
			<tr>
				<th>年龄</th>
				<td><s:textfield name="age"/></td>
			</tr>
			<tr>
				<th><a href="${pageContext.request.contextPath}/user">返回列表</a></th>
				<td><s:submit value="提交"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>