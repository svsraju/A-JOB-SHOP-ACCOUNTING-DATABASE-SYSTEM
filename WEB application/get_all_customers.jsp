<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <meta charset="UTF-8">
 <title>Customers</title>
 </head>
 <body>
 <%@page import="jsp_azure_test.DataHandler1"%>
 <%@page import="java.sql.ResultSet"%>
 <%
 // We instantiate the data handler here, and get all the movies from the database
 	final DataHandler1 handler = new DataHandler1();
 	final ResultSet customers = handler.getAllCustomers();
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
 "</td><td align=\"center\"> " + address +
 "</td><td align=\"center\"> " + category +
 "</td>");
 out.println("</tr>");
 }
 %>
 </table>
 </body>
</html>