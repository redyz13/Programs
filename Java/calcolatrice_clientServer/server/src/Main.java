import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Main {
  private Scanner inp = new Scanner(System.in);
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
      s = inp.nextInt();
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
      System.out.println("\n[Connessione Avviata]\tIn attesa di un client...");
      socket.acceptClient();
      System.out.println("\n[Connessione Effettuata]\tClient connesso");

    } catch (IOException e) {
      System.out.println("\nErrore di connessione");
    }

    System.out.println("[Server in esecuzione]\n");
    esegui();
  }

  public void esegui() throws IOException {
    System.out.println("[Attendo i dati del client...]");

    String s = socket.ricevi();

    if(s.equals("0"))
      chiudiConnessione();

    int x = Integer.parseInt(socket.ricevi());
    int y = Integer.parseInt(socket.ricevi());

    System.out.println("[Invio del risultato al client...]");

    switch (s) {
      case "+" -> socket.invia(Integer.toString(x + y));
      case "-" -> socket.invia(Integer.toString(x - y));
      case "*" -> socket.invia(Integer.toString(x * y));
      case "/" -> socket.invia(Integer.toString(x / y));
    }

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