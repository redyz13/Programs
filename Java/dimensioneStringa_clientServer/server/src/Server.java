import java.io.*;
import java.net.*;

public class Server {
  private ServerSocket server;
  private Socket socket;
  private int porta;
  private BufferedReader br;
  private PrintWriter pw;

  public Server(int porta) throws IOException {
    this.porta = porta;
    this.server = new ServerSocket(porta);
    server.setSoTimeout(10*6000);
  }

  public Socket acceptClient() throws IOException {
    System.out.println("\n[Connessione Avviata]\tIn attesa di un client...");
    socket = server.accept();
    server.close();
    System.out.println("\n[Connessione Effettuata]\tClient connesso");
    System.out.println("[Server in esecuzione]\t\tAttendo i dati del client...\n");

    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

    return socket;
  }

  public String ricevi() throws IOException {
    String s = null;
    socket.setSoTimeout(10*3000);

    try {
      s = br.readLine();
    }
    catch(java.io.InterruptedIOException t) {
      System.err.println("[Timed Out: Tempo di connessione scaduto, nessun input ricevuto (30s)]");
      socket.close();
      closeServer();
    }

    return s;
  }

  public void invia(String x) {
    pw.println(x);
  }

  public void closeServer() throws IOException {
    server.close();
  }

  public Socket getSocket() {
    return socket;
  }

  public void closeConnection() throws IOException {
    System.out.print("[Connessione Terminata]\n");
    socket.close();
  }
}