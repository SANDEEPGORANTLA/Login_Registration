<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<form method="post" action="login">
<table align="center" style="color: black">
	<tr>
		<td colspan="2" align="center" style="color: green"><h1>Login</h1></td>
	</tr>
	<tr>
		<td>UserName:</td>
		<td><input type="text" name="userName" required autofocus="autofocus"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="password" required></td>
	</tr>
	<tr>
		<td><input type="submit"value="Login"></td>
	</tr>			
</table>
</form>
<p align="center"><a href="ForgetPassword.jsp"><input type="submit" value="ForgotPassword"></a></p>
</body>
</html>