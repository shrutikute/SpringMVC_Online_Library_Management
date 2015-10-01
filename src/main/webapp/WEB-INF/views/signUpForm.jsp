<%-- <%@ include file="./include.jsp"%>
<html>
<head>
	<title>New Member Information</title>
	<style>
		.error {
		    font-size: 0.8em;
			color: #ff0000;
		}
	</style>
</head>

<body><center>

<h1><fmt:message key="signUpForm.title" /></h1>

  <form:form action="./processNewSignUpProfile" method="POST" commandName="member">
  <table>
  <tr>
  	<td><fmt:message key="userNameLabel1" /></td>
        <td><form:input path="userName" />
            <form:errors path="userName" cssClass="error"/>
        </td>
    </tr><tr>
  	<td><fmt:message key="passwordLabel1" /></td>
        <td><form:password path="password" />
            <form:errors path="password" cssClass="error"/>
        </td>
    </tr>
	
	<tr><center>
    <td><input type="submit" value="<fmt:message key="enterBtn" />"> </td>
    </center>
    </tr>
    </table>
  </form:form>
 
</body>
</html>
 --%>