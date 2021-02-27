import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Comunicazione {
  private Client socket;
  private InputStreamReader isr;
  private OutputStreamWriter osw;
  private BufferedReader br;
  private BufferedWriter bw;
  private PrintWriter pw;
  private BufferedReader scanner;

  public Comunicazione(Client socket) throws IOException {
    this.socket = socket;
    isr = new InputStreamReader(socket.getSocket().getInputStream());
    osw = new OutputStreamWriter(socket.getSocket().getOutputStream());

    br = new BufferedReader(isr);
    bw = new BufferedWriter(osw);

    pw = new PrintWriter(bw, true);

    scanner = new BufferedReader(new InputStreamReader(System.in));
  }

  public BufferedReader getBufferedReader() {
    return br;
  }

  public BufferedReader getScanner() {
    return scanner;
  }

  public PrintWriter getPrintWriter() {
    return pw;
  }

  public void comunica() throws IOException {
    String numero1, numero2, numeroServer;

    System.out.print("Inserisci il primo numero da trasmettere al server: ");
    numero1 = scanner.readLine();
    pw.println(numero1);

    System.out.print("Inserisci il secondo numero da trasmettere al server: ");
    numero2 = scanner.readLine();
    pw.println(numero2);

    System.out.println("\n[Invio dei numeri al server...]\n");
    numeroServer = br.readLine();
    System.out.println("[Risposta dal server: " + numeroServer + "]");

    socket.getSocket().close();
  }
}
