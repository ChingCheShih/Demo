<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
		* { 
			margin: 0; 
			padding: 0; 
			-webkit-box-sizing: border-box; 
			-moz-box-sizing: border-box;
			box-sizing: border-box;
		}
ul {
    list-style-type: none;''
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
</style>
</head>
<body>

<ul>
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="listAllEmp.jsp">all Emps</a></li>
  <li><a href="addEmp.jsp">add Emp</a></li>
</ul>
<div align="center">
	Demo for Servlet example
</div>
</body>
</html>

