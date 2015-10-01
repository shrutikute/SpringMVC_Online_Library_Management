

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 --%><html>
<head>
<title>New Member Information</title>
</head>
<body>

<h1>Please review the information you entered</h1>

  <form name="memDataFormWithSession" action="./processNewMemberProfile" method="POST">
  <table>
  <tr>
  	<td>Name</td> 
    <td> <input type="TEXT" name="name" value="${member.name}"> </td>
    </tr>
    <tr>
    <td>Address: </td>
    <td> <input type="TEXT" name="address" value="${member.address}"> </td>
    </tr>
    <tr>
    <td>Classification</td>
    <td><input type="radio" name="classification" value="Grad" <c:if test="${member.classification == 'Grad'}"> checked </c:if> > Grad<br>
	<input type="radio" name="classification" value="Undergrad" <c:if test="${member.classification == 'Undergrad'}"> checked </c:if> > Undergrad<br>
	<input type="radio" name="classification" value="Faculty" <c:if test="${member.classification == 'Faculty'}"> checked </c:if> > Faculty<br></td>
	</tr>
	<tr>
    <td><input type="submit" value="Enter"> </td>
    </tr>
    </table>
  </form>
 
</body>
</html>
