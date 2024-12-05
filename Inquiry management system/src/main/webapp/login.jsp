 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
    <h2>Login Here...</h2>
    <%
       if(request.getAttribute("error")!=null){
          out.println(request.getAttribute("error"));
       }
    %>
    
    <form action="verifyLogin" method="post">
      
      email<input type="text" name="email"/>
      password<input type="password" name="password"/>
      <input type ="submit" value="login"/>
    
    </form>
</body>
</html>