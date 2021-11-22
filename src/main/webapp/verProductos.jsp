<%-- 
    Document   : verProductos
    Created on : 15-nov-2021, 17:32:46
    Author     : DAW-A
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Crud"%>
<%@page import="modelo.Productos"%>
<%@page import="modelo.Productos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       
    </head>
    <body>
        <table class="table table-striped">

            <% 
            List<Productos> listado = (List<Productos>) request.getAttribute("productos");
            for (Productos p: listado){ %>
            <tr>
                <td> <%=p.getNombre() %> </td>
                <td> <%= p.getPrecio() %> </td>
                <td><a href="Servlet?op=borrar&id=<%=p.getId() %>">Borrar</a></td>
               
             </tr>
            <% } %>
        </table>
        
    </body>
</html>
