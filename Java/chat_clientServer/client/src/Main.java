import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
      System.out.println("\nSelezionare un opzione\n1. Connetti\n0. Esci");
      System.out.print("\nSelezione: ");
      s = Integer.parseInt(inp.readLine());

      switch (s) {
        case 1 -> connessione();
        case 0 -> chiudi();
      }
    }while (s != 0);
  }

  public void connessione() throws IOException {
    socket = new Client(ip, porta);
    socket.connessione();

    System.out.println("\n[Operazione completata]\n");
    System.out.println("[Immettere :q per uscire dalla chat]\n");

    esegui();
  }

  public void esegui() throws IOException {
    String s, r;

    do {
      System.out.print("[CLIENT]: ");

      s = socket.inviaInput();
      r = socket.ricevi();

      if(s.equals(":q"))
        chiudiConnessione(s);
      else
        System.out.println("[SERVER]: " + r);
    } while(!s.equals(":q"));
  }


  public void chiudiConnessione(String s) throws IOException {
    socket.invia(s); /* Per disconnettere il client dal server invio una stringa
    che gli permette di interrompere la connessione */
    socket.getSocket().close();
  }

  public void chiudi() {
    System.exit(0);
  }
}