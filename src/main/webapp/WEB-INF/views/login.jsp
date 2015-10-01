<%@ include file="./include.jsp"%>

<html>
<head>
<title>Login Page</title>
</head>

<body style="background-color: #BCC6CC;">
<center>
	<h1>Login Page</h1>

	<form:form name="login" action="./login" commandName="loginDetails"
		method="POST">

		<table>

			<tr>
				<td><label>Username</label></td>
				<td><form:input path="userName"></form:input></td>
				<td><font color="red"><form:errors path="userName"></form:errors></font></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><form:input path="password" type="password"></form:input></td>
				<td><font color="red"><form:errors path="password"></form:errors></font></td>
			</tr>
			<tr>
				<td></td>
				<td>
				<a href="/libraryapp/" >Back</a>
				<input type="submit" value="<fmt:message key="enterBtn" />"></td>			
			</tr>
			<tr>
				<td colspan="2" align="center"><font color="red"><form:errors /></font></td>
			</tr>
		</table>

	</form:form>
</body>
</html>





