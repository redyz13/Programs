import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Comunicazione {
  private Server socket;

  public Comunicazione(Server socket) throws IOException {
    this.socket = socket;
  }

  public void communica() throws IOException {
    System.out.println("[Server in esecuzione]\n");
    System.out.println("[Attendo i numeri del client...]");
    
    int min = Integer.MAX_VALUE;
    int n = Integer.parseInt(socket.ricevi());
    int[] a = new int[n];

    for(int i = 0; i < n; i++)
      a[i] = Integer.parseInt(socket.ricevi());

    for(int i = 0; i < n; i++) {
      if(a[i] < min) {
        min = a[i];
      }
    }

    System.out.println("[Invio del numero minore al client...]");
    socket.invia(Integer.toString(min));

    socket.getClient().close();
  }
}
