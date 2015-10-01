<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />

<html>
<head>
<title>DeleteSuccess</title>
</head>
<body style="background-color: #BCC6CC;">
	<h2>
	<label>You Have Successfully Deleted One Entry!! <b> ${member.name} </b>
	</label></h2>
<a href="${context}/success">Home</a>
</body>
</html>
