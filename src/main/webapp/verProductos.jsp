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
        <style>
            td {
                width: 30%;
            }
        </style>
    </head>
    <body> 
        <% 
            List<Productos> listado = (List<Productos>) request.getAttribute("productos");
            String mensaje = (String) request.getAttribute("mensaje");
        %>
       
            
        <% if (mensaje != ""){ %>
                <h2 class="alert alert-success"> <%= mensaje %> </h2>
                  
        <% }     for (Productos p: listado){ %>
        <table class="table table-striped">
            <tr>
                <td> <%=p.getNombre() %> </td>
                <td> <%= p.getPrecio() %> </td>
                <td> <%= p.getCategoria() %></td>
                <td><a href="Servlet?op=borrar&id=<%=p.getId() %>" onclick="return Confirmacion()">Borrar</a></td>
                <td><a href="Servlet?op=actualizar&id=<%=p.getId() %>">Actualizar</a></td>
             </tr>
            <% } %>
        </table>
        <script>
            function Confirmacion(){
                if(confirm ("¿Esta seguro de que \n\ quiere eliminar el producto")){
                    alert("El registro se eliminara");
                    return true;
                } else {
                    return false;
                }
            }
                
                
            
        </script>
    </body>
</html>
