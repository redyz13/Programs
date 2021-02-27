import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Scanner;
public class Main {
  private Scanner inp = new Scanner(System.in);
  private Client socket;
  private String ip = "localhost";
  private int porta = 7000;

  public static void main(String[] args) throws IOException {
    Main m = new Main();
    m.menu();
  }

  public void menu() throws IOException {
    int s;
    do {
      System.out.println("\nSelezionare un opzione\n1. Connetti\n0. Esci");
      System.out.print("\nSelezione: ");
      s = inp.nextInt();
      switch (s) {
        case 1 -> connessione();
        case 0 -> chiudi();
      }
    } while (s != 0);
  }

  public void connessione() throws IOException {
    socket = new Client(ip, porta);
    socket.connessione();

    System.out.println("\n[Operazione completata]\n");

    Comunicazione comunicazione = new Comunicazione(socket);

    comunicazione.comunica();
  }

  public void chiudi() throws IOException {
    System.exit(0);
  }
}