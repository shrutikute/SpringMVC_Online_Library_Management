<%@ include file="./include.jsp"%>
<html>
<head>
<title>New Member Profile Created</title>
</head>
<body>

<h2>A new profile has been successfully created for:
      <font color="blue">${member.name} ${member.address} </font></h2>
<br>
<h2>
<a href="${context}/success">Home</a>
</h2>
      
</body>
</html>
