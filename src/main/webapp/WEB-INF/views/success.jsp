<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />

<html>
<head>
<title>Success</title>
</head>

<div id="titlebar">
   <h1> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp E-Library Management </h1>
</div>
<%@ include file="./homeNavbar2.jsp"%>
<body>
<center>
<img src="${context}/resources/images/pic4.jpg" width="1000" height="500">
</body>
</html>