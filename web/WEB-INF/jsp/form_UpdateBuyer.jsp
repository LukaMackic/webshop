<%-- 
    Document   : form_UpdateBuyer
    Created on : Aug 20, 2020, 5:33:41 PM
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
         <a href="deletebuyer.htm">Delete Buyer</a><br/>
        <a href="index.htm">Home page</a><br/>
      <h1>Update buyer:</h1>
           <form:form action="updatebuyer.htm" method="post" commandName="buyer">
            
            <form:label path="id">Insert ID:</form:label><br/>
            <form:input id="id" type="text" path="id" placeholder="Buyer ID..."></form:input><br/>
            
            <form:label path="name">Insert new name:</form:label><br/>
            <form:input id="name" type="text" path="name" placeholder="new name..."></form:input><br/>
            
            <form:label path="surname">Insert new surname:</form:label><br/>
            <form:input id="surname" type="text" path="surname" placeholder="new surname..."></form:input><br/>
            
            <form:label path="email">Insert new email:</form:label><br/>
            <form:input id="email" type="text" path="email" placeholder="new email..."></form:input><br/>
            <br/>
       
            <input type="submit" value="Submit"/>
        </form:form> </br>
        <label for="buyers" id="buyers_list">All buyers:</label><br/>   
         <textarea id="buyers" rows="20" cols="100" readonly>${buyers}</textarea>    
          </body>
</html>
