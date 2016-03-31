<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>编号</th>
			<td><s:property value="id"/></td>
		</tr>
		<tr>
			<th>名称</th>
			<td><s:property value="userName"/></td>
		</tr>
		<tr>
			<th>年龄</th>
			<td><s:property value="age"/></td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath}/user">返回</a>
</body>
</html>