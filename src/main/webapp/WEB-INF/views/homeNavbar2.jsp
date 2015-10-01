<link rel="stylesheet" type="text/css" href="${context}/resources/css/nav.css" />
<!-- <div id="titlebar">
   <h1> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Library Management </h1>
</div> -->
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />

<%  
String memId = request.getParameter("member"); 
%> 
<div id="wrap">
  <ul id="nav">
	<li><a href="${context}/issueBook">Issue a book</a> 
	<li><a href="${context}/deleteMemberForm">Delete Member</a> 
	<li><a href="${context}/bookmembers">View Member with Issued Books </a> 	
	<li><a href="${context}">Log Out</a>
	<li><label>Hello! <b> ${member.memid}</b></label>
 	 
  </ul>
</div>
    