<%@ include file="./include.jsp"%>
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

<body style="background-color: #BCC6CC;">
<center>
<h1><fmt:message key="memberDataForm.title" /></h1>

  <form:form action="./processNewSignUpProfile" method="POST" commandName="member">
  <table>
  	<tr>
  	<td><fmt:message key="firstnameLabel" /></td>
        <td><form:input path="name" />
            <form:errors path="name" cssClass="error"/>
        </td>
    </tr>
    
    <tr>
  	<td><fmt:message key="addressLabel" /></td>
        <td><form:input path="address" />
            <form:errors path="address" cssClass="error"/>
        </td>
    </tr>
    
    <tr>
    <td><form:label path="classification">Classification</form:label></td>
    <td><form:radiobutton path="classification" value="Grad" checked="true"/> Grad<br>
	<form:radiobutton path="classification" value="Undergrad"/> Undergrad<br>
	<form:radiobutton path="classification" value="Faculty"/> Faculty<br></td>
	</tr>
	
	
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
	
	
	
	<tr>
	<td></td>
    <td><a href="/libraryapp/" >Back</a>
    <input type="submit" value="<fmt:message key="enterBtn" />"> </td>
    </tr>
    </table>
  </form:form>
 
</body>
</html>
