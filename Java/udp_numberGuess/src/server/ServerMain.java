package server;
import java.io.IOException;
import java.util.Scanner;

public class ServerMain {
  private Scanner inp = new Scanner(System.in);
  private ServerUDP serverSocket;
  private int porta = 7000;
  private boolean attivo = true;
  private NumberGuess numberGuess;

  public static void main(String[] args) throws IOException {
    ServerMain sm = new ServerMain();
    sm.dashboard();
  }

  private void dashboard() throws IOException {
    int s;
    do {
      System.out.println("\nSelezionare un'opzione\n1. Comunica\n0. Esci");
      System.out.print("\nSelezione: ");
      s = inp.nextInt();
      switch (s) {
        case 1 -> comunica();
        case 0 -> System.exit(0);
      }
    } while (true);
  }

  private void comunica() throws IOException {
    try {
      serverSocket = new ServerUDP(porta);
    }
    catch(IOException e) {
      System.err.println("\nErrore server");
    }

    System.out.println("\n[Server Pronto]");

    numberGuess = new NumberGuess();

    System.out.println("[Numero generato = " + numberGuess.getNumeroEstrazione() + "]");

    ricevi(); // Ricevo pacchetto di test da cui ricavo ip e porta del client
    serverSocket.invia(""); // Invio pacchetto di test

    int x;

    while(attivo) {
      String n = ricevi();

      if(!n.equals(""))
        System.out.println("\n[Ricevuto : " + n + "]");

      checkAndClose(n, "q");

      try {
        x = Integer.parseInt(n);
      }catch (NumberFormatException ne) {
        x = -1;
      }

      if(x == numberGuess.getNumeroEstrazione()) {
        serverSocket.invia("y");
        System.out.println("[Numero indovinato dal client, connessione terminata]");
        chiudiConnessione();
      }
      else {
        serverSocket.invia("n");
        if(x != -1)
          System.out.println("[Numero sbagliato]");
      }
    }
  }

  private void checkAndClose(String x, String closeString) throws IOException {
    if(x.equals(closeString)) {
      System.out.println("\n[Connessione Terminata]");
      chiudiConnessione();
    }
  }

  private void chiudiConnessione() throws IOException {
    serverSocket.getServerSocket().close();
    attivo = true;
    dashboard();
  }

  private String ricevi() throws IOException {
    String s = serverSocket.ricevi();
    
    if(s.equals("q")) {
      System.out.println("\n[Connessione Terminata dal client]");
      chiudiConnessione();
    }
    else if(s.equals("so"))
      chiudiConnessione();

    return s;
  }
}