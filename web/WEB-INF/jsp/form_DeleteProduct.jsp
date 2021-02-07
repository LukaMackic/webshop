<%-- 
    Document   : DeleteProduct
    Created on : Aug 20, 2020, 6:37:21 PM
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
         <a href="product.htm">New Product</a><br/>
        <a href="updateproduct.htm">Update Product</a><br/>
         <a href="index.htm">Home page</a><br/>
        <h1>Delete Product:</h1>
       <form:form action="deleteproduct.htm" method="post" commandName="product">
            
            <form:label path="id">Insert ID:</form:label><br/>
            <form:input id="id" type="text" path="id" placeholder="Product ID..."></form:input><br/>
    
            <input type="submit" value="Submit"/>
       </form:form> </br>
           <label for="products" id="products_list">All products:</label><br/>
           <textarea id="products" rows="20" cols="100" readonly>${products}</textarea>  
    </body>
</html>
