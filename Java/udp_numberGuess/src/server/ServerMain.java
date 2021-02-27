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

  public void dashboard() throws IOException {
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

  public void comunica() throws IOException {
    try {
      serverSocket = new ServerUDP(porta);
    }
    catch(IOException e) {
      System.err.println("\nErrore server");
    }

    System.out.println("\n[Server Pronto]");

    ricevi(); // Ricevo pacchetto di test da cui ricavo ip e porta del client
    serverSocket.invia(""); // Invio pacchetto di test

    numberGuess = new NumberGuess();
    int numeroEstrazione = numberGuess.getRandomNumber();
    numberGuess.setNumeroEstrazione(numeroEstrazione);

    System.out.println("[Numero generato = " + numberGuess.getNumeroEstrazione() + "]");

    while(attivo) {
      String n = ricevi();
      System.out.println("\n[Ricevuto : " + n + "]");

      if(n.equals("q")) {
        attivo = false;
        break;
      }

      int x = Integer.parseInt(n);

      if(x == numberGuess.getNumeroEstrazione()) {
        serverSocket.invia("y");
        System.out.println("[Numero indovinato dal client, connessione terminata]");
        attivo = false;
      }
      else {
        serverSocket.invia("n");
        System.out.println("[Numero sbagliato]");
      }
    }

    chiudiConnessione();
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