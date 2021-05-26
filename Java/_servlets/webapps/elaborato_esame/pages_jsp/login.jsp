<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <% if(session.getAttribute("username") != null)
            response.sendRedirect("carta.jsp");
       else if(session.getAttribute("username2") != null)
            response.sendRedirect("paginaEsercenti.jsp");
    %>
</head>
<body>

</body>
</html>