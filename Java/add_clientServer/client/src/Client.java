import java.io.*;
import java.net.*;

public class Client {
  private String ip;
  private int porta;
  private Socket socket;

  public Client(String ip, int porta) throws IOException {
    this.ip = ip;
    this.porta = porta;
  }

  public Socket connessione() throws IOException {
    socket = new Socket(ip, porta);

    return socket;
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
