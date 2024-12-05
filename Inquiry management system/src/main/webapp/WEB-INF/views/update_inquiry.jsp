<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Inquiry</title>
</head>
<body>

     <h2>Update Student details</h2>
    
      <form action="updateInquiry" method="post">
      <pre>
		      email<input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
		      mobile<input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
		      <input type ="submit" value="Update Inquiry"/>
		      
      
      </pre>
    
    </form>
     
</body>
</html>