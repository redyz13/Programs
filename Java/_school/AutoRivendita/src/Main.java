import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
  private Scanner in = new Scanner(System.in);
  private ListaAuto listaAuto = new ListaAuto();
  private ListaClienti listaClienti = new ListaClienti();
  private Auto auto;
  private Cliente cliente;

  public static void main(String[] args) {
    Main m = new Main();
    Finestra f = new Finestra();
    f.setVisible(true);
    m.menu();
  }

  public void menu() {
    creazioneAuto();
    int s;
    do {
      System.out.println("\nSelezionare un opzione\n1. Visualizza Catalogo\n2. Accesso/Acquisto" +
          "\n3. Visualizza Clienti\n0. Esci");
      System.out.print("\nSelezione: ");
      s = in.nextInt();
      switch(s) {
        case 1: visualizzaAuto();break;
        case 2: registrazione();
        case 3: visualizzaClienti();
        case 0: break;
      }
    } while (s != 0);
  }

  private void visualizzaAuto() {
    listaAuto.visualizzaObject();
  }

  private void registrazione() {
    String r, nome, cognome, codiceFiscale, numeroCarta, targa;
    int autoAcquistate, password;
    double creditoCarta;
    System.out.print("\n- Per acquistare un auto è necessario registrarsi -\n");
    System.out.print("\tProcedere alla registrazione? (s/n): "); r = in.next();
    if(r.equals("s")) {
      System.out.print("\n- Inserizione Dati -\n");
      System.out.print("\tNome: "); nome = in.nextLine(); nome = in.nextLine();
      System.out.print("\tCognome: "); cognome = in.nextLine();
      System.out.print("\tCodice Fiscale: "); codiceFiscale = in.nextLine();
      System.out.print("\tNumero Carta: "); numeroCarta = in.nextLine();

      creditoCarta = ThreadLocalRandom.current().nextInt(2000, 7000 + 1);
      password = ThreadLocalRandom.current().nextInt(100, 1000 + 1);

      cliente = new Cliente(nome, cognome, codiceFiscale, 0, numeroCarta, creditoCarta, Integer.toString(password));
      listaClienti.addObject(cliente);
      System.out.print("\n- Registrazione Effettuata -\n");
      System.out.print("\tLa sua password di accesso è: " + cliente.getPassword() + "\n");
    }
    else {
      System.out.print("\nEffettuare il login? (s/n): "); r = in.next();
      if(r.equals("s")) {
        String password1;
        System.out.print("\nInserire la password: "); password1 = in.nextLine(); password1 = in.nextLine();
        cliente = listaClienti.getObjectPsw(password1);
        if(cliente != null) {
          acquistaAuto(cliente);
        }
        else
          System.out.print("\n- Utente non trovato -\n");
      }
      else
        System.out.print("\n- Operazione annullata -\n");
    }
  }

  private void acquistaAuto(Cliente cliente) {
    String targa;
    System.out.print("\nInserire il numero di targa dell'auto da acquistare: "); targa = in.nextLine();
    auto = listaAuto.getObject(targa);
    if(auto != null) {
      System.out.print("\nPrezzo auto: €" + auto.getPrezzo());
      if(cliente.getCreditoCarta() > auto.getPrezzo()) {
        cliente.setCreditoCarta(cliente.getCreditoCarta() - auto.getPrezzo());
        listaAuto.removeAuto(targa);
        System.out.print("\n- Acquisto Effettuato -\n");
      }
      else
        System.out.print("\n- Credito insufficiente -\n");
    }
    else
      System.out.print("\n- Auto non trovata -\n");
  }

  private void visualizzaClienti() {
    //listaClienti.visualizzaObject();
  }

  private void creazioneAuto() {
    for(int i = 0; i < 5; i++) {
      auto = new Auto("Marca" + i, "Modello" + i, "Stato Auto" + i, "Targa" + i, "Tipo",
          2010 + i, 1 + i, (i + 1) * 30, (i + 1) * 50 + 1000 * 2);
      listaAuto.addObject(auto);
    }
  }
}