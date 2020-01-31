<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Result</title>
</head>
<body>
<%@page import="jsp_azure_test.DataHandler1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Array"%>
<%
// The handler is the one in charge of establishing the connection.
DataHandler1 handler = new DataHandler1();
// Get the attribute values passed from the input form.
String minCat = request.getParameter("min_cat");
String maxCat = request.getParameter("max_cat");

/*
* If the user hasn't filled out all the time, movie name and duration. This is very simple
checking.
*/
if (minCat.equals("") || maxCat.equals("") ) {
response.sendRedirect("retrieve_customers_form.jsp");
} else {
int duration = Integer.parseInt(minCat);
int duration1 = Integer.parseInt(maxCat);
// Now perform the query with the data from the form.
final ResultSet customers = handler.retrieveCustomers(duration,duration1);
%>
<!-- The table for displaying all the movie records -->
<table cellspacing="2" cellpadding="2" border="1">
<tr> <!-- The table headers row -->
<td align="center">
<h4>Customer Name</h4>
</td>
<td align="center">
 <h4>Customer Address</h4>
 </td>
 <td align="center">
 <h4>Category</h4>
 </td>
</tr>
<%
while(customers.next()) { // For each movie_night record returned...
	// Extract the attribute values for every row returned
	final String name = customers.getString("name");
	final String address = customers.getString("address");		
	final String category = customers.getString("category");	
	out.println("<tr>"); // Start printing out the new table row
	out.println( // Print each attribute value
	"<td align=\"center\">" + name +
	"<td align=\"center\">" + address +
	"<td align=\"center\">" + category +
	"</td>");
	out.println("</tr>");
	 }
 
}

%>


</body>
</html>