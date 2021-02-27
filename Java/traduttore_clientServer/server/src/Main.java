import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
  private Scanner inp = new Scanner(System.in);
  private Server server;
  private int porta = 7000;
  private List<String> lcodes = Arrays.asList("uk", "UK", "de", "DE", "el", "EL");
  private List<String> dl = Arrays.asList("uno", "UNO", "due", "DUE", "tre", "TRE");

  public static void main(String[] args) throws IOException {
    Main m = new Main();
    m.dashboard();
  }

  private void dashboard() throws IOException {
    int s;
    do {
      System.out.println("\nSelezionare un'opzione\n1. Avvia Connessione\n0. Esci");
      System.out.print("\nSelezione: ");
      s = inp.nextInt();
      switch (s) {
        case 1 -> connessione();
        case 0 -> System.exit(0);
      }
    } while (s != 0);
  }

  private void connessione() throws IOException {
    try {
      server = new Server(porta);
    }
    catch (IOException e) {
      System.err.println("\nErrore server");
    }

    try {
      server.acceptClient();
      sendData();
      esegui();
    }
    catch (java.io.InterruptedIOException t) {
      System.err.println("\n[Timed Out: Tempo di connessione scaduto (60s)]");
      server.closeServer();
      dashboard();
    }
    catch(java.net.SocketException se) {
      System.err.print("");
    }
    catch (IOException | InterruptedException e) {
      System.err.println("\n[Errore di connessione]");
    }
  }

  private void sendData() {
    server.invia(lcodes.toString());
  }

  private void disconnect() throws IOException {
    System.out.println("\n[Eseguo Disconnessione]\n");
    server.closeConnection();
    dashboard(); /* Richiamo la dashboard per tornare al punto di partenza
        ed eventualmente riaprire la connessione per un altro client*/
  }

  private void esegui() throws IOException, InterruptedException {
    String r = null;
    int code; // 0 = UK, 1 = DE, 2 = EL
    String s = server.ricevi();

    if(s == null)
      s = "q";

    if(!lcodes.contains(s) || s.equals("q"))
      disconnect();

    System.out.println("\t--->\tRicevuto correttamente il dato: (" + s + ")\n");

    String t = server.ricevi();

    if(t == null)
      disconnect();

    System.out.println("\t--->\tRicevuto correttamente il dato: (" + t + ")\n");

    if(s.equals(lcodes.get(0)) || s.equals(lcodes.get(1))) {
      code = 0;
      r = checkWord(t, code);
    }
    else if(s.equals(lcodes.get(2)) || s.equals(lcodes.get(3))) {
      code = 1;
      r = checkWord(t, code);
    }
    else if(s.equals(lcodes.get(4)) || s.equals(lcodes.get(5))) {
      code = 2;
      r = checkWord(t, code);
    }
    else
      esegui();

    System.out.println("[Invio del risultato al client...]");

    server.invia(r);

    System.out.println("\n\t<---\tInviato correttamente il dato: (" + r + ")");

    System.out.println("\n[Attendo nuovi dati...]\n");

    esegui(); /* Metodo ricorsivo utilizzato per mantenere la connessione
    e continuare a eseguire operazioni per lo stesso client*/
  }

  private String checkWord(String t, int code) {
    if(t.equals(dl.get(0)) || t.equals(dl.get(1))) {
      switch (code) {
        case 0 -> {
          return "one";
        }
        case 1 -> {
          return "ein";
        }
        case 2 -> {
          return "ένας";
        }
      }
    }
    else if(t.equals(dl.get(2)) || t.equals(dl.get(3))) {
      switch (code) {
        case 0 -> {
          return "two";
        }
        case 1 -> {
          return "zwei";
        }
        case 2 -> {
          return "δύο";
        }
      }
    }
    else if(t.equals(dl.get(4)) || t.equals(dl.get(5))) {
      switch (code) {
        case 0 -> {
          return "three";
        }
        case 1 -> {
          return "drei";
        }
        case 2 -> {
          return "τρία";
        }
      }
    }
    return null;
  }
}