import java.io.*;
import java.net.*;

public class Client {
  private String ip;
  private int porta;
  private Socket socket;
  private BufferedReader br;
  private PrintWriter pw;
  private BufferedReader scanner;

  public Client(String ip, int porta) throws IOException {
    this.ip = ip;
    this.porta = porta;
  }

  public Socket connessione() throws IOException {
    socket = new Socket(ip, porta);

    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    scanner = new BufferedReader(new InputStreamReader(System.in));

    return socket;
  }

  public String inviaInput() throws IOException {
    String x = scanner.readLine();
    pw.println(x);

    return x;
  }

  public void invia(String x) {
    pw.println(x);
  }

  public String ricevi() throws IOException {
    return br.readLine();
  }

  public Socket getSocket() {
    return socket;
  }
}
