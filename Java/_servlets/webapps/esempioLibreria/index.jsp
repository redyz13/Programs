<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Esempio Liberia</title>
        <link rel="stylesheet" href="style.css">
        <%@ include file = "funzioni.jsp"%>
        <% String s = request.getParameter("stringa");%>
    </head>
    <body>
        <div class="text">
            <h2>Inclusione di file con codice JSP</h2>
            <p>La pagina invia i parametri a se stessa trasformati in formato comptabile con SQL</p>
        </div>
        <form action="index.jsp" method="GET">
            Stringa: <input type = "text" name = "stringa">
            <input type="submit" value="Invia">
        </form>
    </br>
        Risultato: <%= getSQL(s)%>
    </body>
</html>