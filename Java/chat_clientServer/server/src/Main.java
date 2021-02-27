import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
public class Main {
  private BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
  private Server socket;
  private int porta = 7000;

  public static void main(String[] args) throws IOException {
    Main m = new Main();
    m.dashboard();
  }

  public void dashboard() throws IOException {
    int s;
    do {
      System.out.println("\nSelezionare un opzione\n1. Avvia Connessione\n0. Esci");
      System.out.print("\nSelezione: ");
      s = Integer.parseInt(inp.readLine());
      switch (s) {
        case 1 -> connessione();
        case 0 -> chiudi();
      }
    } while (s != 0);
  }

  void connessione() throws IOException {
    try {
      socket = new Server(porta);
    } catch (IOException e) {
      System.out.println("\nErrore server");
    }

    try {
      socket.acceptClient();
    } catch (IOException e) {
      System.out.println("\nErrore di connessione");
    }

    System.out.println("[Server in esecuzione]\n");
    esegui();
  }

  public void esegui() throws IOException {
    String s = socket.ricevi();
    String r;

    System.out.println("[CLIENT]: " + s);

    if(s.equals(":q"))
      chiudiConnessione();

    System.out.print("[SERVER]: ");

    r = inp.readLine();

    socket.invia(r);

    esegui(); /* Metodo ricorsivo utilizzato per mantenere la connessione
    e continuare a eseguire operazioni per lo stesso client*/
  }

  public void chiudiConnessione() throws IOException {
    socket.getClient().close();
    dashboard(); /* Richiamo la dashboard per tornare al punto di partenza
    ed eventualmente riaprire la connessione per un altro client*/
  }

  public void chiudi() {
    System.exit(0);
  }
}