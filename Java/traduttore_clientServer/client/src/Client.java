import java.io.*;
import java.net.*;

public class Client {
  private String ip;
  private int porta;
  private Socket socket;
  private BufferedReader br;
  private PrintWriter pw;
  private BufferedReader scanner;
  private boolean connected;

  public Client(String ip, int porta) throws IOException {
    this.ip = ip;
    this.porta = porta;
  }

  public Socket connessione() throws IOException {
    socket = new Socket(ip, porta);

    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    scanner = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("\n[Operazione completata]\n");
    setConnected(true);
    return socket;
  }

  public void invia(String x) throws IOException {
    try {
      pw.println(x);
    }
    catch (Exception e) {
      e.getMessage();
    }
  }

  public String ricevi() throws IOException, InterruptedException {
    String s = null;

    try {
      s = br.readLine();
    }
    catch(SocketException se) {
      System.err.print("\n[Timed Out: Tempo di connessione scaduto]\n");
      setConnected(false);
      Thread.sleep(100);
    }
    catch(Exception e) {
      System.err.print("\n[Errore]\n");
      setConnected(false);
    }

    return s;
  }

  public boolean isConnected() {
    return connected;
  }

  public void setConnected(boolean connected) {
    this.connected = connected;
  }

  public void closeConnection() throws IOException {
    System.out.print("\n[Connessione Terminata]\n");
    socket.close();
  }
}
