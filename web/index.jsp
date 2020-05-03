<%-- 
    Document   : index
    Created on : 01-may-2020, 16:13:51
    Author     : vicent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestion de empleados e incidencias</h1>
        <h2>-------------------------------------------------------------</h2>
        <form action="ServletEmpleados" method="POST"><b>Visualizar un listado de todos los empleados.</b>
            <input type="submit" name="verempleados" value="ver" />           
        </form>
        </br>
        <form action="nuevoEmpl.html" method="POST"><b>insertar un nuevo empleado.</b>
            <input type="submit" name="insertarempleado" value="insertar" />           
        </form>
        </br>
        <form action="ServletLogin" method="POST"><b>Log in.</b>
            <p>usuario: <input type="text" name="usuario"></p>
            <p>contrasena: <input type="text" name="password"></p>
            <input type="submit" name="Login" value="Entrar" />           
        </form>
        </br>
    </body>
</html>
