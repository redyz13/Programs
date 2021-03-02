package client;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientUDP {
  private byte[] bufferIN;
  private byte[] bufferOUT;
  private DatagramSocket clientSocket;
  private DatagramPacket receivePacket;
  private DatagramPacket sendPacket;
  private int porta;
  InetAddress ip;
  private int timeout = 10*3000;

  public ClientUDP(InetAddress ip, int porta) {
    try {
      bufferIN = new byte[1024];
      bufferOUT = new byte[1024];
      this.ip = ip;
      this.porta = porta;
      this.clientSocket = new DatagramSocket();
      this.receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
    }catch (SocketException u) {
      System.out.println(u.toString());
    }
  }

  public String ricevi() throws IOException {
    clientSocket.setSoTimeout(timeout); // Timer ricezione

    try {
      clientSocket.receive(receivePacket);
    }catch (java.io.InterruptedIOException t) {
      System.out.println("\n[Nessuna risposta dal server, connessione chiusa]");
      //System.exit(0);
      return "so";
    }

    return fixData();
  }

  private String fixData() {
    String ricevuto = new String(receivePacket.getData());

    int numCaratteri = receivePacket.getLength();
    ricevuto = ricevuto.substring(0, numCaratteri); // Elimina caratteri in eccesso

    return ricevuto;
  }

  public void invia(String daSpedire) throws IOException {
    bufferOUT = daSpedire.getBytes();

    sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, ip, porta);

    clientSocket.send(sendPacket);
  }

  public DatagramSocket getClientSocket() {
    return clientSocket;
  }
}