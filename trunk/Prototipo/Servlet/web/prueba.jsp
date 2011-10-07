<%-- 
    Document   : prueba
    Created on : 09/02/2011, 05:33:32 PM
    Author     : Fran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>PRUEBA!</h1>
        <form action="/Servlet/Servletprueba">
            <% String example = "AAAA";
            request.getSession().setAttribute("parm1","pepin"); %>
            <p>
                Por favor mostrame::::: <% out.print(example.toString()); %>
            </p>
            <input type="submit" name="confirmar">
        </form>
    </body>
</html>
