import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
  private ServerSocket server;
  private Socket socket;
  private int porta;
  private BufferedReader br;
  private PrintWriter pw;

  public Server(int porta) throws IOException {
    this.porta = porta;
    this.server = new ServerSocket(porta);
  }

  public Socket acceptClient() throws IOException {
    socket = server.accept();
    server.close();

    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

    return socket;
  }

  public String ricevi() throws IOException {
    return br.readLine();
  }

  public void invia(String x) {
    pw.println(x);
  }

  public Socket getClient() {
    return socket;
  }
}