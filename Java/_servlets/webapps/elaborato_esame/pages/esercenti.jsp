<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Servizio Carta di Credito</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />
        <% if(session.getAttribute("username2") != null) 
            response.sendRedirect("../pages_jsp/paginaEsercenti.jsp");
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
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="utenti.jsp">Pagina Utenti</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="esercenti.jsp">Pagina Esercenti</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <header class="bg-primary text-white">
            <div class="container text-center">
                <h1>Pagina dedicata agli esercenti</h1>
                <p class="lead">Selezionare se registrarsi o effettuare il login</p>
            </div>
        </header>
        <section id="login">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2>Accedi</h2>
                        <p class="lead">Inserire i seguenti dati:</p>
                        <form action="../accessoEsercente" method="post">
                            <center>
                                <div class = "login" style = >
                                    <label>Username: </label> <input name="username" type = "text"> <br><br>
                                    <label>Password: </label> <input name="pword" type = "password"> <br><br>
                                    <input type="submit" value = "Accedi">
                                </div>     
                            </center>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <section class="bg-light" id="registrazione">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2>Registrati</h2>
                        <p class="lead">Inserire i seguenti dati:</p>
                        <form action="../registrazioneEsercente" method="post">
                            <center>
                                <div class = "login" style = >
                                    <label>Nome: </label> <input name="nome" type = "text"> <br><br>
                                    <label>Cognome: </label> <input name="cognome" type = "text"> <br><br>
                                    <label>Username: </label> <input name="username" type = "text"> <br><br>
                                    <label>Password: </label> <input name="pword" type = "password"> <br><br>
                                    <input type="submit" value = "Registrati">
                                </div>     
                            </center>
                        </form>
                    </div>
                </div>
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
