<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div> 信息：<s:actionmessage /> </div>
	<table>
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<s:iterator value="model">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="userName"/></td>
			<td><s:property value="age"/></td>
			<td>
                <a href="user/${id}">查看show()</a>
                <a href="user/${id}/edit">修改edit()</a>
                <a href="user/${id}?_method=DELETE">删除delete()</a>
			</td>
		</tr>	
		</s:iterator>
	</table>
	<a href="user/new">添加用户editNew()</a>
</body>
</html>