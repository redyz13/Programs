import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
  private ServerSocket server;
  private Socket socket;
  private int porta;
  private InputStreamReader isr;
  private OutputStreamWriter osw;
  private BufferedReader br;
  private BufferedWriter bw;
  private PrintWriter pw;

  public Server(int porta) throws IOException {
    this.porta = porta;
    this.server = new ServerSocket(porta);
  }

  public Socket acceptClient() throws IOException {
    System.out.println("\n[Connessione Avviata]\tIn attesa di un client...");
    socket = server.accept();
    server.close();
    System.out.println("\n[Connessione Effettuata]\tClient connesso");

    isr = new InputStreamReader(socket.getInputStream());
    osw = new OutputStreamWriter(socket.getOutputStream());

    br = new BufferedReader(isr);
    bw = new BufferedWriter(osw);

    pw = new PrintWriter(bw, true);

    return socket;
  }

  public String ricevi() throws IOException {
    return br.readLine();
  }

  public void invia(String x) {
    pw.println(x);
  }

  public ServerSocket getServerSocket() {
    return server;
  }

  public Socket getClient() {
    return socket;
  }
}