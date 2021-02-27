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
  private InputStreamReader isr;
  private OutputStreamWriter osw;
  private BufferedReader br;
  private BufferedWriter bw;
  private PrintWriter pw;

  public Comunicazione(Server socket) throws IOException {
    this.socket = socket;
    isr = new InputStreamReader(socket.getClient().getInputStream());
    osw = new OutputStreamWriter(socket.getClient().getOutputStream());

    br = new BufferedReader(isr);
    bw = new BufferedWriter(osw);

    pw = new PrintWriter(bw, true);
  }

  public BufferedReader getBufferedReader() {
    return br;
  }

  public PrintWriter getPrintWriter() {
    return pw;
  }

  public void communica() throws IOException {
    System.out.println("[Server in esecuzione]\n");
    System.out.println("[Attendo i numeri del client...]");

    int numero1 = Integer.parseInt(br.readLine());
    int numero2 = Integer.parseInt(br.readLine());
    int numeroServer = numero1 + numero2;

    System.out.println("[Invio della somma al client...]");
    pw.println(Integer.toString(numeroServer));

    socket.getClient().close();
  }

}
