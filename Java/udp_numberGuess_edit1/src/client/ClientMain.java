package client;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.io.BufferedReader;

public class ClientMain {
  private BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
  private ClientUDP clientSocket;
  private MultiCastReciever mr;
  private InetAddress ip;
  private int porta = 7000;
  private boolean attivo = true;


  public static void main(String[] args) throws IOException {
    ClientMain cm = new ClientMain();
    cm.dashboard();
  }

  public void dashboard() throws IOException {
    int s;
    do {
      System.out.println("\nSelezionare un'opzione\n1. Comunica\n0. Esci");
      System.out.print("\nSelezione: ");
      s = Integer.parseInt(inp.readLine());
      switch (s) {
        case 1 -> comunica();
        case 0 -> System.exit(0);
      }
    } while (true);
  }

  public void comunica() throws IOException {
    ip = InetAddress.getByName("localhost");
    clientSocket = new ClientUDP(ip, porta);
    mr = new MultiCastReciever(porta);

    clientSocket.invia(""); // Invio pacchetto di test per dare ip e porta al server
    ricevi(); // Ricevo pacchetto di test

    System.out.println("\n[Client Pronto]");

    System.out.print("""
          \n- Funzionamento del server -
          \tSe non si inviano o ricevono dati entro 30 secondi la connessione si annulla
          \tIl seguente server genera un numero compreso tra 0 e 100
          \tche è possibile indovinare per vincere
          \tScrivere q per annullare immediatamente la connessione
          """);

    while(attivo) {
      System.out.print("\nInserisci un numero: ");
      String s = inp.readLine();

      clientSocket.invia(s);

      checkAndClose(s, "q");

      String risposta = mr.ricevi();
      char r = risposta.charAt(0);

      if(r == 'y') {
        System.out.println("[Numero Indovinato!]");
        System.out.println("\n[Connessione Terminata]");
        chiudiConnessione();
      }
      else
        System.out.println("[Riprova!]");
    }
  }

  private void checkAndClose(String x, String closeString) throws IOException {
    if(x.equals(closeString)) {
      System.out.println("\n[Connessione Terminata]");
      chiudiConnessione();
    }
  }

  private void chiudiConnessione() throws IOException {
    clientSocket.getClientSocket().close();
    attivo = true;
    dashboard();
  }

  private String ricevi() throws IOException {
    String s = clientSocket.ricevi();
    if(s.equals("q")) {
      System.out.println("\n[Connessione Terminata]");
      chiudiConnessione();
    }
    else if(s.equals("so"))
      chiudiConnessione();

    return s;
  }
}