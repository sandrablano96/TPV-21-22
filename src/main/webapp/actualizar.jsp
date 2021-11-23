<%-- 
    Document   : actualizar
    Created on : 22-nov-2021, 17:42:54
    Author     : DAW-A
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <% String mensaje = (String) request.getAttribute("mensaje"); %>
        <% String operacion = (String) request.getAttribute("operacion"); %>
        <h1>Formulario productos</h1>
        <% if (mensaje != null){ %>
                <h2 class="alert alert-success"> <%= mensaje %> </h2>
           <% }%>
        <form action="Servlet?op=<%=operacion%>" method="post">
        <p>Id:<input type="text" name="id" value="${producto.id}" readonly> </p>
        <p>Nombre:<input type="text" name="nombre" value="${producto.nombre}"> </p>
        <p>Categoria: <input type="text" name="categoria" value="${producto.categoria}"></p>
        <p>Precio: <input type="text" name="precio" value="${producto.precio}"></p>
        <input type="submit" value="Enviar">
        </form>
    </body>
</html>
