<%-- 
    Document   : form_product
    Created on : Aug 20, 2020, 6:36:50 PM
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
          <a href="updateproduct.htm">Update Product</a><br/>
        <a href="deleteproduct.htm">Delete Product</a><br/>
         <a href="index.htm">Home page</a><br/>
        <h1>New Product:</h1>
           <form:form action="product.htm" method="post" commandName="product">
            
            <form:label path="name">Insert name:</form:label><br/>
            <form:input id="name" type="text" path="name" placeholder="product name..."></form:input><br/>
            
            <form:label path="price">Insert price:</form:label><br/>
            <form:input id="price" type="text" path="price" placeholder="product price..."></form:input><br/>
            
            <form:label path="quantity">Insert quantity:</form:label><br/>
            <form:input id="quantity" type="text" path="quantity" placeholder="prodct quantity..."></form:input><br/>
            <br/>
       
            <input type="submit" value="Submit"/>
        </form:form> </br>
           <label for="products" id="products_list">All products:</label><br/>
        <textarea id="products" rows="20" cols="100" readonly>${products}</textarea>    
    </body>
</html>
