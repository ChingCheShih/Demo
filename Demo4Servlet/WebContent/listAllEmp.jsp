<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>

<%
    EmpService empSvc = new EmpService();
	List<EmpVO> list = empSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	table {
		width:80%;
	}
	table  th{
		background-color: black;
    		color: white;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<table border="1px solid black">
		<tr>
			<th>職位</th>
			<th>姓名</th>
			<th>年齡</th>
			<th>薪資</th>
		</tr>
		<%@ include file="page1.file" %>
		<c:forEach var="empVO" items="${list}" begin="<%=pageIndex%>"  end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle'>
			<td>${empVO.job }</td>
			<td>${empVO.name }</td>
			<td>${empVO.age }</td>
			<td>${empVO.sal }</td>			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/EmpServlet" >
			     <input type="submit" value="修改" >
			     <input type="hidden" name="id" value="${empVO.id}">
			     <input type="hidden" name="action"value="update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/EmpServlet">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="id" value="${empVO.id}">
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
	</table>
		<%@ include file="page2.file" %>
	</div>
</body>
</html>