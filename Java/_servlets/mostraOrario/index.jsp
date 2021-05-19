<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mostra Orario</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%! int getIterazioni() {return 10;}; %>
        <div class="date">
            <h2>La data di oggi &egrave;:</h2>
            <p><%= new java.util.Date().toString() %></p>
            <% for(int i = 0; i < getIterazioni(); i++) { %>
                Questa &egrave; la riga numero <%= i %> </br>
            <% } %>    
        </div>
    </body>
</html>