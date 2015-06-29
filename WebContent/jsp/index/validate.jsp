<%-- 
    Document   : validate
    Created on : 2015-5-20, 10:22:40
    Author     : Fla
--%>

<%@ page contentType="text/html" language="java" import="java.sql.*" errorPage="" %> 
<% 
String rand = (String)session.getAttribute("rand"); 
String input = request.getParameter("rand"); 
if(rand.equalsIgnoreCase(input)){ 
out.print("<script>alert('pass');</script>"); 
} else{ 
out.print("<script>alert('Wrong verification code');location.href='../send-enquiry.jsp';</script>"); 
} 
%> 