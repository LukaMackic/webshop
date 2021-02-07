<%-- 
    Document   : form_Sale
    Created on : Aug 21, 2020, 9:56:11 PM
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
        <h1>New Sale:</h1>
           <form:form action="sale.htm" method="post" commandName="sale">
            
            
            <form:label path="product_id">Insert product:</form:label><br/>
            <form:input id="product_id" type="text" path="product_id" placeholder="product id..."></form:input><br/>
            
            <form:label path="quantity">Insert quantity:</form:label><br/>
            <form:input id="quantity" type="text" path="quantity" placeholder="prodct quantity..."></form:input><br/>
            <br/>
       
            <input type="submit" value="Submit"/>
        </form:form> </br>
           <label for="products" id="products_list">All products:</label><br/>
        <textarea id="products" rows="20" cols="100" readonly>${products}</textarea>    
    </body>
</html>
