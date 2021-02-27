import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {
  public static void main(String[] args) throws IOException {
    int portaServer = 7000;
    InetAddress IPServer = InetAddress.getByName("localhost");

    byte[] bufferIN = new byte[1024]; // Buffer spedizione e ricezione
    byte[] bufferOUT = new byte[1024];

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    // Creazione del socket
    DatagramSocket clientSocket = new DatagramSocket();
    System.out.print("[Client Pronto]\nInserisci un dato da inviare: ");

    // Preparazione del messaggio da spedire
    String daSpedire = input.readLine();
    bufferOUT = daSpedire.getBytes();

    // Trasmissione del dato al server
    DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPServer, portaServer);
    clientSocket.send(sendPacket);

    // Ricezione del dato dal server
    DatagramPacket recievePacket = new DatagramPacket(bufferIN, bufferIN.length);
    clientSocket.receive(recievePacket);
    String ricevuto = new String(recievePacket.getData());

    // Elaborazione dei dati ricevuti
    int numCaratteri = recievePacket.getLength();
    ricevuto = ricevuto.substring(0, numCaratteri); // Elimina caratteri in eccesso
    System.out.println("[Risposta del server]: " + ricevuto);

    // Termine Elaborazione
    clientSocket.close();
  }
}
