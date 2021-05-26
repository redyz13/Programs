<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Informazioni Transazioni</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />
        <link href="../css/card.css" rel="stylesheet" />
        <% if(session.getAttribute("username") == null) 
                response.sendRedirect("../pages/utenti.jsp");
        %>
        <%@ page import="java.sql.*"%>
        <%@ page import="java.util.*"%>
        <%! String username;%>
        <% username = (String) session.getAttribute("username"); %>
        <%!
            Connection con;
            Statement statement;
            public void jspInit() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_elaborato", "root", "");
                    statement = con.createStatement();
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        %>
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top">Servizio Carta di Credito</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../index.html">Home</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../pages/utenti.jsp">Pagina Utenti</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="../pages/esercenti.jsp">Pagina Esercenti</a></li>
                        <% if(session.getAttribute("username") != null)
                            out.print("<li class = \"nav-item\"><a class=\"nav-link js-scroll-trigger\" href=\"../pages/logoutEffettuato.jsp\">Logout</a></li>");
                        %>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="bg-primary text-white">
            <div class="container text-center">
                <h1>Transazioni di pagamento</h1>
                <p class="lead">Lista delle transazioni della propria carta</p>
            </div>
        </header>
        <section class="bg-light">
            <div class="container">
                <div class="card" style="margin-top: 10px;">
                    <div class="face front-face">
                        <div class="d-flex align-items-center justify-content-between">
                            <div class="card-type">Carta di credito</div>
                            <div class="bank-name">Servizio Carta di Credito</div>
                        </div>
                    <div class="d-flex align-items-center justify-content-between pt-2"> <img src="https://img.icons8.com/officel/2x/sim-card-chip.png" alt="chip" class="emv-chip">
                        <div class="wifi me-4"> <span class="fas fa-wifi fs-3"></span> </div>
                    </div>
                    <div class="d-flex justify-content-between flex-column card-details pt-2">
                        <% ResultSet rs = statement.executeQuery("SELECT numero FROM carta c INNER JOIN titolare t ON c.codiceTitolare = t.codiceTitolare WHERE t.username = \""+ username +"\""); 
                            while(rs.next()) {
                        %>
                        <% out.println("<div class=\"card-number\">"+rs.getString(1)+"</div>");%>
                        <% } %>
                        <% rs.close(); %>
                        <div class="d-flex align-items-center expiry py-2">
                        <div class="d-flex flex-column text-uppercase">
                            <div>Valida</div>
                            <div>fino al</div>
                        </div>
                        <%  rs = statement.executeQuery("SELECT month(dataScadenza), year(dataScadenza) FROM carta c INNER JOIN titolare t ON c.codiceTitolare = t.codiceTitolare WHERE t.username = \""+ username +"\""); 
                            while(rs.next()) {
                        %>
                        <% out.println("<div class=\"ps-3\"> <span class=\"month\">"+rs.getInt(1)+"</span> / <span class=\"year\">"+rs.getString(2)+"</span> </div>"); %>
                        <% } %>
                        <% rs.close(); %>
                        </div>
                        <%  rs = statement.executeQuery("SELECT nome, cognome FROM Titolare t WHERE t.username = \""+ username +"\""); 
                            while(rs.next()) {
                        %>
                        <% out.println("<div class=\"card-holder pt-2 text-uppercase\">"+rs.getString(1)+ " " + rs.getString(2) +"</div>");%>
                        <% } %>
                        <% rs.close(); %>
                    </div>
                    <div class="master d-flex justify-content-end"> <img src="https://www.freepnglogos.com/uploads/mastercard-png/mastercard-marcus-samuelsson-group-2.png" alt=""> </div>
                    </div>
                    <div class="face back-face">
                    <div class="black-bar mt-4"></div>
                    <div class="authorize text-uppercase ps-3 pt-3">Firma autorizzata: non valida a meno che non sia firmata </div>
                    <div class="d-flex position-relative">
                        <div class="white-bar ms-3"></div>
                        <%  rs = statement.executeQuery("SELECT ccv FROM carta c INNER JOIN titolare t ON c.codiceTitolare = t.codiceTitolare WHERE t.username = \""+ username +"\""); 
                            while(rs.next()) {
                        %>
                        <% out.println("<b><div class=\"cvv d-flex justify-content-center\">"+rs.getInt(1)+"</div></b>");%>
                        <% } %>
                        <% rs.close(); %>   
                    </div>
                        <div class="mx-3 mt-3 back-text"> Carta di credito fornita da: Servizio Carta di Credito. Valida fino alla data di scadenza indicata </div>
                    </div>
                </div>                
            <div class="container">
            <h2>Transazioni</h2>
            <p>Elenco delle transazioni effettuate sulla seguente carta di credito:</p>
            <table class="table">
                <thead>
                <tr>
                    <th>Codice Movimento</th>
                    <th>Importo Transazione</th>
                    <th>Data Transazione</th>
                    <th>Descrizione</th>
                </tr>
                </thead>
                <tbody>
                <%
                    rs = statement.executeQuery("SELECT codiceMovimento, importoTransazione, dataTransazione, descrizione FROM movimenti m INNER JOIN carta c ON c.codiceCarta = m.codiceCarta INNER JOIN titolare t ON c.codiceTitolare = t.codiceTitolare WHERE t.username = \""+ username +"\" ORDER BY dataTransazione DESC");
                    while(rs.next()) {
                %>
                    <tr>
                        <% out.println("<td>"+rs.getInt(1)+"</td>"); %>
                        <% out.println("<td>"+rs.getInt(2)+"</td>"); %>
                        <% out.println("<td>"+rs.getDate(3)+"</td>"); %>
                        <% out.println("<td>"+rs.getString(4)+"</td>"); %>
                    </tr>
                <% } %>
                </tbody>
            </table>
            <% rs.close(); %>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Antonio D'Auria &copy; Elaborato Esame</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/3.2.1/anime.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
