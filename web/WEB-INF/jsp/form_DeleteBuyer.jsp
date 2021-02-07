<%-- 
    Document   : form_DeleteBuyer
    Created on : Aug 20, 2020, 6:15:42 PM
    Author     : Korisnik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebShop</title>
    </head>
    <body>
         <a href="buyer.htm">Add Buyer</a><br/>
         <a href="updatebuyer.htm">Update Buyer</a><br/>
         <a href="index.htm">Home page</a><br/>
           <h1>Delete buyer:</h1>
      <form:form action="deletebuyer.htm" method="post" commandName="buyer">
            
            <form:label path="id">Insert ID:</form:label><br/>
            <form:input id="id" type="text" path="id" placeholder="Buyer ID..."></form:input><br/>
      
            <br/>
       
            <input type="submit" value="Delete"/>
        </form:form> </br>
        <label for="buyers" id="buyers_list">All buyers:</label><br/>   
         <textarea id="buyers" rows="20" cols="100" readonly>${buyers}</textarea>    
    </body>
</html>
