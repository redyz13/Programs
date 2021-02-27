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
    m.menu();
  }

  public void menu() throws IOException {
    int s;
    do {
      System.out.println("\nSelezionare un opzione\n1. Connessione\n0. Esci");
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
    }
    catch (IOException e) {
      System.out.println("\nErrore server");
    }

    try {
      socket.acceptClient();
    }
    catch (IOException e) {
      System.out.println("\nErrore di connessione");
    }

    Comunicazione comunicazione = new Comunicazione(socket);
    comunicazione.communica();
  }

  public void chiudi() throws IOException {
    System.exit(0);
  }
}