<%-- 
    Document   : form_buyer
    Created on : Aug 20, 2020, 1:43:30 PM
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
        <a href="updatebuyer.htm">Update Buyer</a><br/>
        <a href="deletebuyer.htm">Delete Buyer</a><br/>
         <a href="index.htm">Home page</a><br/>
        <h1>New buyer:</h1>
        <form:form action="buyer.htm" method="post" commandName="buyer">
            
            <form:label path="name">Insert name:</form:label><br/>
            <form:input id="name" type="text" path="name" placeholder="your name..."></form:input><br/>
            
            <form:label path="surname">Insert surname:</form:label><br/>
            <form:input id="surname" type="text" path="surname" placeholder="your surname..."></form:input><br/>
            
            <form:label path="password">Insert password:</form:label><br/>
            <form:input id="password" type="text" path="password" placeholder="your password..."></form:input><br/>
            
            <form:label path="email">Insert email:</form:label><br/>
            <form:input id="email" type="text" path="email" placeholder="your email..."></form:input><br/>
            <br/>
       
            <input type="submit" value="Submit"/>
        </form:form> </br>
           <label for="buyers" id="buyers_list">All buyers:</label><br/>
        <textarea id="buyers" rows="20" cols="100" readonly>${buyers}</textarea>    
     
    </body>
</html>
