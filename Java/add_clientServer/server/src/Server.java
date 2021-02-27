import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
  private ServerSocket server;
  private Socket socket;
  private int porta;

  public Server(int porta) throws IOException {
    this.porta = porta;
    this.server = new ServerSocket(porta);
  }

  public Socket acceptClient() throws IOException {
    System.out.println("\n[Connessione Avviata]\tIn attesa di un client...");
    socket = server.accept();
    server.close();
    System.out.println("\n[Connessione Effettuata]\tClient connesso");

    return socket;
  }

  public ServerSocket getServerSocket() {
    return server;
  }

  public Socket getClient() {
    return socket;
  }
}