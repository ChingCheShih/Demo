<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.emp.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color:  #111;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

 .imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
} 

img.avatar {
    width: 20%;
    border-radius: 25%;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add Employee</title>
</head>
<body>

<h4>員工資料:<font color=red><b>*</b></font>為必填欄位</h4>
	<font color='red'>請修正以下錯誤:
		<c:forEach var="err" items="${errorMsgs}">
			<li>${err.value}</li>
		</c:forEach>
	</font>
	
	<c:set var="data" value="${data}"/>

<form action="EmpServlet"  method="post">
  <div class="container" width="50%">
    <label><b>job</b></label><span style="color:Red;">*</span>
    <input type="hidden" value="${data.id}" name="id" >
    
    <input type="text" placeholder="Enter job"  value="${data.job}" name="job" required >${err.job}<br>
    
    <label><b>name</b></label><span style="color:Red;">*</span>
    <input type="text" placeholder="Enter name"  value="${data.name}" name="name" required>${err.name}<br>
    
     <label><b>age</b></label><span style="color:Red;">*</span>
    <input type="text" placeholder="Enter age"  value="${data.age}"  name="age" required>${err.age}<br>
     
     <label><b>sal</b></label><span style="color:Red;">*</span>
    <input type="text" placeholder="Enter sal" value="${data.sal}" name="sal" required>${err.sal}<br>
        
    <button type="submit" name="action" value="insert">儲存</button>
  </div>

</form>

</body>
</html>