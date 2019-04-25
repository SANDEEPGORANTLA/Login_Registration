<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="login">
<table align="center" style="color: red">
				<tr>
					<td colspan="2" align="center" style="color: blue"><h2>ForgetPassword</h2></td>
				</tr>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="userName" required></td>
				</tr>
					<tr>
					<td>password:</td>
					<td><input type="password" name="password" ></td>
				</tr>
				</tr>
					<tr>
					<td>Confirmpassword:</td>
					<td><input type="password" name="confirmpassword" ></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Verfiy"></td>
					<td align="center"><input type="reset" name="Reset Form"></td>
				</tr>
</table>

</body>
</html>