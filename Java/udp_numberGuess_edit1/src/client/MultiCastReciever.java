package client;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastReciever {
  private MulticastSocket ms;
  private String group = "127.0.0.1";
  private int porta;
  private DatagramPacket receivePacket;
  private byte[] bufferIN;

  public MultiCastReciever(int porta) throws IOException {
    this.porta = porta;
    ms = new MulticastSocket(7001);
    bufferIN = new byte[1024];
  }

  public String ricevi() throws IOException {
    receivePacket = new DatagramPacket(bufferIN, bufferIN.length);
    ms.receive(receivePacket);

    String ricevuto = new String(receivePacket.getData());

    int numCaratteri = receivePacket.getLength();
    ricevuto = ricevuto.substring(0, numCaratteri); // Elimina caratteri in eccesso

    ms.leaveGroup(InetAddress.getByName(group));
    ms.close();

    return ricevuto;
  }
}
