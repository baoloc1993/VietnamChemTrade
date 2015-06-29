<%-- 
    Document   : login
    Created on : 2015-5-20, 10:21:24
    Author     : Fla
--%>

<%@ page contentType="text/html" %> 
<%@ page language="java" import="java.sql.*" errorPage="" %> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8"> 
<title>login</title> 
<script language="javascript"> 
function loadimage(){ 
document.getElementById("randImage").src = "image.jsp?"+Math.random(); 
} 
</script> 
</head> 
<body> 
<table width="256" border="0" cellpadding="0" cellspacing="0"> 
<!--DWLayoutTable--> 
	<form action="validate.jsp" method="post" name="loginForm"> 
		<tr> 
			<td width="118" height="22" valign="middle" align="center">
				<input type="text" name="rand" size="15">
			</td> 
			<td width="138" valign="middle" align="center">
				<img alt="code..." name="randImage" id="randImage" src="image.jsp" width="120" height="50" border="1" align="absmiddle">
			</td> 
		</tr> 
		<tr> 
			<td height="36" colspan="2" align="center" valign="middle"><a href="javascript:loadimage();"><font class=pt95>refresh</font></a></td> 
		</tr> 
		<tr> 
			<td height="36" colspan="2" align="center" valign="middle"><input type="submit" name="login" value="submit"></td> 
		</tr> 
	</form> 
</table> 
</body> 
</html>