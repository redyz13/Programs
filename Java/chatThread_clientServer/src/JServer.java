import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JServer {

  private ServerSocket server;
  private Socket socket;
  private int port;
  private PrintWriter pw;
  private BufferedReader br;

  public JServer() {
    port = 6789;
  }

  public Socket connect() throws IOException {

    System.out.println("[CONNECT] Sto provando a stabilire una connessione");
    server = new ServerSocket(port);
    System.out.println("[CONNECT] Connessione avviata");

    System.out.println("[CONNECT] Sto attendendo un client");
    socket = server.accept();
    System.out.println("[CONNECT] Connessione avviata con \t" + socket.toString());

    pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    return socket;
  }

  public void communicazione() {

    Thread lettura = new Thread(new Lettura(this));
    Thread scrittura = new Thread(new Scrittura(this));

    lettura.start();
    scrittura.start();

  }

  public PrintWriter getPw() {
    return pw;
  }

  public void setPw(PrintWriter pw) {
    this.pw = pw;
  }

  public BufferedReader getBr() {
    return br;
  }

  public void setBr(BufferedReader br) {
    this.br = br;
  }

  public ServerSocket getServer() {
    return server;
  }

  public void setServer(ServerSocket server) {
    this.server = server;
  }

  public Socket getSocket() {
    return socket;
  }

  public void setSocket(Socket socket) {
    this.socket = socket;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public static void main(String[] args) {
    JServer server = new JServer();
    try {
      server.connect();
    } catch (IOException e) {
      System.out.println("Errore");
    }
    server.communicazione();
  }

}
