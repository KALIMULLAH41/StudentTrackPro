<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Inquiry</title>
</head>
<body>

     <h2>Enter Student details</h2>
     <% 
     if(request.getAttribute("msg")!=null){
          out.println(request.getAttribute("msg"));
       }
     %>
      <form action="addInquiry" method="post">
      <pre>
              name<input type="text" name="name"/>
		      email<input type="text" name="email"/>
		      mobile<input type="text" name="mobile"/>
		      course<input type="text" name="course"/>
		      <input type ="submit" value="Add Inquiry"/>
		      
      
      </pre>
    
    </form>
     
</body>
</html>