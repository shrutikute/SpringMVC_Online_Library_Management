<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<head>
	<title>Library Management Home Page</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
</head>
<body >
<%@ include file="./homeNavbar.jsp"%>
<center>
<h1>Welcome to our Library</h1>
<img src="${context}/resources/images/pic1.jpg" width="1000" height="500">
<br>
<br>
<br>
</body>
</html>
