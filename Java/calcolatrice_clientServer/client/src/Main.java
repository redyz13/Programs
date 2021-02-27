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

    esegui();
  }

  public void esegui() throws IOException {
    String s;
    do {
      System.out.println("""
          Selezionare un'operazione tramite carattere:
          \t[+] Addizione
          \t[-] Sottrazione
          \t[*] Moltiplicazione
          \t[/] Divisione
          \t[0] Esci""");
      System.out.print("\nSelezione: ");
      s = inp.readLine();
      switch (s) {
        case "+" -> opera("+");
        case "-" -> opera("-");
        case "*" -> opera("*");
        case "/" -> opera("/");
        case "0" -> chiudiConnessione("0");
      }
    } while(!s.equals("0"));
  }

  public void opera(String s) throws IOException {
    String x, y, r;

    socket.invia(s);

    System.out.print("\nInserisci il primo operando: ");
    x = socket.inviaInput();
    System.out.print("Inserisci il secondo operando: ");
    y = socket.inviaInput();

    r = socket.ricevi();

    System.out.println("\n[Risposta dal server: " + r + "]\n");
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