package server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastSender {
  private MulticastSocket ms;
  private String group = "127.0.0.1"; // Range degli indirizzi ip
  private int porta = 7000;
  private DatagramPacket sendPacket;

  public MultiCastSender() throws IOException {
    ms = new MulticastSocket();
  }

  public void invia(String daSpedire) throws IOException {
    sendPacket = new DatagramPacket(daSpedire.getBytes(), daSpedire.length(), InetAddress.getByName(group), 6789);
    ms.send(sendPacket);
    ms.close();
  }
}
