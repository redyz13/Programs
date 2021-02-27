import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerUDP {
  public static void main(String[] args) throws IOException {
    DatagramSocket serverSocket = new DatagramSocket(7000);

    boolean attivo = true; // Per la ripetizione del servizio

    byte[] bufferIN = new byte[1024]; // Buffer spedizione e ricezione
    byte[] bufferOUT = new byte[1024];

    System.out.println("[Server Avviato]");

    while(attivo) {
      // Definizione del datagramma
      DatagramPacket recievePacket = new DatagramPacket(bufferIN, bufferIN.length);

      serverSocket.setSoTimeout(10*3000); // Timer di chiusura in caso di non ricezione
      try {
        // Attesa della ricezione del dato del client
        serverSocket.receive(recievePacket);
      } catch (java.io.InterruptedIOException t) {
        System.out.print("[Nessun input ricevuto durante il tempo stabilito, connessione chiusa]");
        System.exit(0);
      }

      // Analisi del pacchetto ricevuto
      String ricevuto = new String(recievePacket.getData());
      int numCaratteri = recievePacket.getLength();
      ricevuto = ricevuto.substring(0, numCaratteri); // Elimina caratteri in eccesso
      System.out.println("[Ricevuto : " + ricevuto + "]");


      // Riconoscimento dei parametri del socket del client
      InetAddress IPClient = recievePacket.getAddress();
      int portaClient = recievePacket.getPort();

      // Preparo i dati da spedire
      String daSpedire = ricevuto.toUpperCase();
      bufferOUT = daSpedire.getBytes();

      // Invio del datagramma
      DatagramPacket sendPacket = new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);
      serverSocket.send(sendPacket);

      // Controllo termine esecuzione del server
      if (ricevuto.equals("fine")) {
        System.out.println("[Server Chiuso]");
        attivo = false;
      }
    }

    serverSocket.close();
  }
}