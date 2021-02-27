import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.util.Scanner;
public class Main {
  private BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
  private Client socket;
  private String ip = "localhost";
  private int porta = 7000;

  public static void main(String[] args) throws IOException {
    Main m = new Main();
    m.dashboard();
  }

  public void dashboard() throws IOException {
    int s;
    do {
      System.out.println("\nSelezionare un'opzione\n1. Connetti\n0. Esci");
      System.out.print("\nSelezione: ");
      s = Integer.parseInt(inp.readLine());

      switch (s) {
        case 1 -> connessione();
        case 0 -> System.exit(0);
      }
    }while (s != 0);
  }

  public void connessione() throws IOException {
    socket = new Client(ip, porta);
    try {
      socket.connessione();
      esegui();
    }
    catch (ConnectException | InterruptedException c) {
      System.err.println("[Errore di connessione]\n");
    }
  }

  public void esegui() throws IOException, InterruptedException {
    System.out.print("""
          - Funzionamento del server -
          \tSe non si inviano dati entro 30 secondi la connessione si annulla
          \tIl seguente server permette di calcolare la dimensione di una stringa
          \tScrivere q per annullare immediatamente la connessione
          """);

    String s, r;

    do {
      System.out.print("\nInserire una stringa (oppure uscire scrivendo q): ");
      s = inp.readLine();

      System.out.println("\n\t<---\tInvio del dato: (" + s + ")");
      socket.invia(s);

      if(s.equals("q"))
        chiudiConnessione(s);

      r = socket.ricevi();

      if(socket.isConnected()) {
        System.out.println("\t--->\tDimensione stringa ricevuta: (" + r + ")");
      }

    } while(!s.equals("q") && socket.isConnected());
  }

  public void chiudiConnessione(String s) throws IOException {
    socket.invia(s); /* Per disconnettere il client dal server invio una stringa
    che gli permette di interrompere la connessione */
    socket.closeConnection();
  }
}