<%@ include file="./include.jsp"%>
<html>
<head>
	<title>List Of Books</title>
	<style>
		.error {
		    font-size: 0.8em;
			color: #ff0000;
		}
	</style>
</head>

<body style="background-color: #BCC6CC;">
<center>
  <h1>List Of Books</h1>
  <label>Member ID : <b> ${applicationModel.member.memid}</b></label>
  
  <table BORDER="8" bgcolor="#FAEBD7" cellspacing="10" cellpadding="15">
<tr>
	<th>Book Name</th>
</tr>
	<c:forEach var="curBook" items="${bookList}">
		<tr>
			
		   <td>${curBook.title}</td><td><a href ="${context}/bookIssued?bookId=${curBook.bookid}&memId=1000">Issue</a></td>
		   
		   <%-- <td><c:url value="/bookIssued" var="theUrl">
						<c:param name="bookID" value="${curBook.bookid}" />
						<c:param name="memID" value="${member.memid}" />
					</c:url> <a href="${theUrl}">Issue</a></td> --%>
					
		</tr>
	</c:forEach>
</table>

<br>
<a href="${context}/success">Back</a>
</body>
</html>