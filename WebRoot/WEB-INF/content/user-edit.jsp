<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>修改用户，id为<s:property value="id"/></div>
	<s:form action="%{#request.contextPath}/user/%{id}" method="post">
		<!-- 注意此处加的隐藏域，表示是put请求 -->
		<s:hidden name="_method" value="put" />
		<table>
			<tr>
				<th>编号</th>
				<s:textfield name="id" disabled="true"/>
			</tr>
			<tr>
				<th>名称</th>
				<s:textfield name="userName" />
			</tr>
			<tr>
				<th>年龄</th>
				<s:textfield name="age" />
			</tr>
			<tr>
				<s:submit/>
			</tr>
		</table>
	</s:form>
<a href="${pageContext.request.contextPath}/user">返回列表</a>
</body>
</html>