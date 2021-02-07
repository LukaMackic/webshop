<%-- 
    Document   : form_login
    Created on : Aug 22, 2020, 10:40:17 AM
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
         <a href="index.htm">Home page</a><br/>
         <h1> Log in</h1>
          <form:form action="login.htm" method="post" commandName="login">
            
            <form:label path="id">Insert ID:</form:label><br/>
            <form:input id="id" type="text" path="id" placeholder="your ID..."></form:input><br/>
              
            <form:label path="password">Insert password:</form:label><br/>
            <form:input id="password" type="password" path="password" placeholder="your password..."></form:input><br/>
            
            <input type="submit" value="Submit"/>
        </form:form> </br>
           <label for="buyers" id="buyers_list">All buyers:</label><br/>
        <textarea id="buyers" rows="20" cols="100" readonly>${buyers}</textarea>    
    </body>
</html>
