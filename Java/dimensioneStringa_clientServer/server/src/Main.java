import java.io.IOException;
import java.util.Scanner;
public class Main {
  private Scanner inp = new Scanner(System.in);
  private Server server;
  private int porta = 7000;

  public static void main(String[] args) throws IOException {
    Main m = new Main();
    m.dashboard();
  }

  private void dashboard() throws IOException {
    int s;
    do {
      System.out.println("\nSelezionare un'opzione\n1. Avvia Connessione\n0. Esci");
      System.out.print("\nSelezione: ");
      s = inp.nextInt();
      switch (s) {
        case 1 -> connessione();
        case 0 -> System.exit(0);
      }
    } while (s != 0);
  }

  private void connessione() throws IOException {
    try {
      server = new Server(porta);
    }
    catch (IOException e) {
      System.err.println("\nErrore server");
    }

    try {
      server.acceptClient();
      esegui();
    }
    catch (java.io.InterruptedIOException t) {
      System.err.println("\n[Timed Out: Tempo di connessione scaduto (60s)]");
      server.closeServer();
      dashboard();
    }
    catch(java.net.SocketException se) {
      System.err.print("");
    }
    catch (IOException | InterruptedException e) {
      System.err.println("\n[Errore di connessione]");
    }
  }

  private void esegui() throws IOException, InterruptedException {
    String lenght;
    String s = server.ricevi();

    if(s == null)
      s = "q";

    if(s.equals("q")) {
      System.out.println("\n[Eseguo Disconnessione]\n");
      server.closeConnection();
      dashboard(); /* Richiamo la dashboard per tornare al punto di partenza
        ed eventualmente riaprire la connessione per un altro client*/
    }

    System.out.println("\t--->\tRicevuto correttamente il dato: (" + s + ")\n");
    lenght = Integer.toString(s.length());

    System.out.println("[Invio del risultato al client...]");

    server.invia(lenght);

    System.out.println("\n\t<---\tInviato correttamente il dato: (" + lenght + ")");


    System.out.println("\n[Attendo nuovi dati...]\n");

    esegui(); /* Metodo ricorsivo utilizzato per mantenere la connessione
    e continuare a eseguire operazioni per lo stesso client*/
  }
}