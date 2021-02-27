import java.io.*;
import java.net.*;

public class Client {
  private String ip;
  private int porta;
  private Socket socket;
  private InputStreamReader isr;
  private OutputStreamWriter osw;
  private BufferedReader br;
  private BufferedWriter bw;
  private PrintWriter pw;
  private BufferedReader scanner;

  public Client(String ip, int porta) throws IOException {
    this.ip = ip;
    this.porta = porta;
  }

  public Socket connessione() throws IOException {
    socket = new Socket(ip, porta);

    isr = new InputStreamReader(socket.getInputStream());
    osw = new OutputStreamWriter(socket.getOutputStream());

    br = new BufferedReader(isr);
    bw = new BufferedWriter(osw);

    pw = new PrintWriter(bw, true);

    scanner = new BufferedReader(new InputStreamReader(System.in));

    return socket;
  }

  public String ricevi() throws IOException {
    String x = scanner.readLine();
    pw.println(x);

    return x;
  }

  public String invia() throws IOException {
    return br.readLine();
  }

  public String getNomeServer() {
    return ip;
  }

  public int getPort() {
    return porta;
  }

  public Socket getSocket() {
    return socket;
  }
}
