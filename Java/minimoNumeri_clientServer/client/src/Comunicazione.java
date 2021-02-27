import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Comunicazione {
  private Client socket;

  public Comunicazione(Client socket) throws IOException {
    this.socket = socket;
  }

  public void comunica() throws IOException {
    String n, x, min;

    System.out.print("Inserisci il valore dei numeri da inserire: ");
    n = socket.ricevi();

    int y = Integer.parseInt(n);

    for(int i = 0; i < y; i++) {
      System.out.print("\tInserisci il numero " + (i + 1) + " da trasmettere al server: ");
      x = socket.ricevi();
    }

    System.out.println("\n[Invio dei numeri al server...]\n");
    min = socket.invia();
    System.out.println("[Risposta dal server: " + min + "]");

    socket.getSocket().close();
  }
}
