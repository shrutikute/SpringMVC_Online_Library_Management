<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Find Books Issued</title>
</head>
<body style="background-color: #BCC6CC;"> <center>
<h1>Enter the Book Name</h1>
<form name="GetBookForm" action="./listMembers.html" method="GET">
    Book Name: <input type="TEXT" name="bookName">
    <input type="submit" value="Lookup">
    <br><br><a href="${context}/success">Back</a>
</form>
</body>
</html>