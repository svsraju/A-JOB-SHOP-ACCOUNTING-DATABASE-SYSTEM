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
String name = request.getParameter("name");
String address = request.getParameter("address");
String categoryString = request.getParameter("category");

/*
* If the user hasn't filled out all the time, movie name and duration. This is very simple
checking.
*/
if (name.equals("") || address.equals("") || categoryString.equals("")) {
response.sendRedirect("add_customer_form.jsp");
} else {
int category = Integer.parseInt(categoryString);
// Now perform the query with the data from the form.
boolean success = handler.addCustomer(name, address, category);
if (!success) { // Something went wrong
%>
<h2>There was a problem inserting the course</h2>
<%
} else { // Confirm success to the user
%>
<h2>The New Customer:</h2>
<ul>
<li>Customer Name: <%=name%></li>
<li>Customer Address: <%=address%></li>
<li>Category: <%=categoryString%></li>

</ul>
<h2>Was successfully inserted.</h2>
<a href="get_all_customers.jsp">See all Customers.</a>
<%
}
}
%>
</body>
</html>