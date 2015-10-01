<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>New Member Information</title>
</head>
<body>

<h1>Please review the information you entered</h1>

  <form name="editOrSubmitMemDataForm" action="./editOrStoreMemberProfile" method="POST">
  <table>
  <tr>
  	<td>Last Name:</td> 
    <td> ${member.name} </td>
    </tr>
    <tr>
    <td>Address: </td>
    <td> ${member.address}</td>
    </tr>
    <tr>
    <td>Classification:</td>
    <td>${member.classification}</td>
	</tr>
	<tr>
    <td><input type="submit" name="editProfile" value="Edit"> </td>
    <td><input type="submit" name="createProfile" value="Create Profile"> </td>
    </tr>
    </table>
  </form>
 
</body>
</html>
