package server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MultiCastSender {
  private MulticastSocket ms;
  private String group = "0.0.0.0"; // Range degli indirizzi ip
  private int porta = 7000;
  private DatagramPacket sendPacket;

  public MultiCastSender() throws IOException {
    ms = new MulticastSocket();
  }

  public void invia(String daSpedire) throws IOException {
    sendPacket = new DatagramPacket(daSpedire.getBytes(), daSpedire.length(), InetAddress.getByName(group), porta);
    ms.send(sendPacket);
    ms.close();
  }
}
