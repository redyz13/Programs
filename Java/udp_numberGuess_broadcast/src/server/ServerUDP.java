package server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDP {
  private byte[] bufferIN;
  private byte[] bufferOUT;
  private DatagramSocket serverSocket;
  private DatagramPacket receivePacket;
  private int porta;
  private int timeout = 10*3000;

  public ServerUDP(int porta) throws SocketException {
    try {
      this.porta = porta;
      bufferIN = new byte[1024];
      bufferOUT = new byte[1024];
      this.serverSocket = new DatagramSocket(porta);
      this.receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
    }catch (SocketException e) {
      System.out.println(e.toString());
    }
  }

  public String ricevi() throws IOException {
    serverSocket.setSoTimeout(timeout); // Timeout input
    try {
      serverSocket.receive(receivePacket);
    }catch (java.io.InterruptedIOException t) {
      System.out.println("\n[Nessun input ricevuto durante il tempo stabilito, connessione chiusa]");
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
    DatagramPacket sendPacket;

    InetAddress IPClient = receivePacket.getAddress();
    int portaClient = receivePacket.getPort();

    bufferOUT = daSpedire.getBytes();

    sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);

    serverSocket.send(sendPacket);
  }

  public DatagramSocket getServerSocket() {
    return serverSocket;
  }
}