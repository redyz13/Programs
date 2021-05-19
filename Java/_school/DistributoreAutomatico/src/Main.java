import java.util.Scanner;
public class Main {
  private static Scanner in = new Scanner(System.in);
  private static Distributore distributore = new Distributore();
  private static Prodotto prodotto;
  private static int sceltaMenu, scelta, codice, codiceop, qty;
  private static double creditoUtente, credito;

  public static void main(String[] args) {
    creazioneProdotti();
    do {
      menu();
    }while(sceltaMenu != 0);
  }

  private static void menu() {
    System.out.println("\nSelezionare un opzione\n1. Menu Utente\n2. Menu Operatore\n0. Esci");
    System.out.print("\nSelezione: ");
    sceltaMenu = in.nextInt();
    switch(sceltaMenu) {
      case 1: menuUtente(); break;
      case 2:
        System.out.print("\nInserisci codice operatore: "); codiceop = in.nextInt();
        if(Distributore.getCodiceOperatore() == codiceop)
          menuOperatore();
        else
          System.out.print("\n- Codice Errato -\n");
      break;
      case 0: break;
    }
  }

  private static void menuUtente() {
    boolean exit = false;
    while(!exit) {
      System.out.println("\n1. Visualizza Prodotti\n2. Aggiungi Credito\n3. Visualizza Credito" +
          "\n4. Acquista Prodotto\n0. Esci");
      System.out.print("\nSelezione: ");
      scelta = in.nextInt();
      switch(scelta) {
        case 1: visualizzaProdotti(); break;
        case 2: aggiungiCredito(); break;
        case 3: visualizzaCredito(); break;
        case 4: acquistaProdotto(); break;
        case 0: exit = true; break;
      }
    }
  }

  private static void menuOperatore() {
    boolean exit = false;
    while(!exit) {
      System.out.println("\n1. Rifornisci Prodotti\n2. Visualizza Prodotti\n3. Rifornisci Credito" +
          "\n4. Visualizza Introito\n5. Ricava Introito \n0. Esci");
      System.out.print("\nSelezione: ");
      scelta = in.nextInt();
      switch(scelta) {
        case 1: rifornisciProdotti(); break;
        case 2: visualizzaProdotti(); break;
        case 3: rifornisciCredito(); break;
        case 4: visualizzaIntroito(); break;
        case 5: ricavaIntroito(); break;
        case 0: exit = true; break;
      }
    }
  }

  private static void visualizzaProdotti() {
    Distributore.visualizzaProdotti();
  }

  private static void aggiungiCredito() {
    System.out.print("\nInserire il credito: € "); creditoUtente = in.nextDouble();
    Distributore.incCreditoUtente(creditoUtente);
    System.out.print("\n- Credito Aggiunto -\n");
  }

  private static void visualizzaCredito() {
    System.out.println("\nCredito Inserito: € " + Distributore.getCreditoUtente());
  }

  private static void acquistaProdotto() {
    insCodice();
    System.out.print(Distributore.getStringProdotto(codice));
    if(Distributore.getProdotto(codice, 0) != null) {
      System.out.print("\nConfermare l'acquisto? (1. Si - 0. No): "); scelta = in.nextInt();
      if(scelta == 0)
        System.out.print("\n- Acquisto Annullato -\n");
      else if(scelta == 1)
        if(Distributore.verProdotto(codice) == 0 && Distributore.getCreditoUtente() == Distributore.getProdotto(codice, 0).getPrezzo()) {
          System.out.print("\n- Acquisto Effettuato -\n");
          Distributore.decProdotto(codice);
          Distributore.addIntroito(Distributore.getProdotto(codice, 0).getPrezzo());
          Distributore.decCreditoUtente(Distributore.getProdotto(codice, 0).getPrezzo());
        }
        else if(Distributore.verProdotto(codice) == 0 && Distributore.getCreditoUtente() > Distributore.getProdotto(codice, 0).getPrezzo()) {
          System.out.print("\n- Resto = € " + (Distributore.getCreditoUtente() - Distributore.getProdotto(codice, 0).getPrezzo()) + " -\n");
          calcolaResto();
        }
        else
          System.out.print("\n- Credito insufficiente -\n");
    }
  }

  private static void rifornisciProdotti() {
    System.out.print("\nSelezionare il prodotto in base al codice: "); codice = in.nextInt();
    if(Distributore.getProdotto(codice, 1) != null) {
      System.out.print("\nInserire la quantità del prodotto da aggiungere: "); qty = in.nextInt();
      if(Distributore.incProdotto(codice, qty) == 0)
        System.out.print("\n- Prodotto Rifornito -\n");
    }
    else
      System.out.print(Distributore.getStringProdotto(codice));
  }

  private static void rifornisciCredito() {
    System.out.print("\nInserire il credito da aggiungere: "); credito = in.nextDouble();
    Distributore.incIntroito(credito);
    System.out.print("\n- Credito Aggiunto -\n");
  }

  private static void visualizzaIntroito() {
    System.out.println("\nIntroito: € " + Distributore.getIntroito());
  }

  private static void ricavaIntroito() {
    System.out.print("\nInserire il credito da ricavare: "); credito = in.nextDouble();
    if(Distributore.decIntroito(credito) == 0)
      System.out.print("\n- Credito Ricavato -\n");
    else
      System.out.print("\n- Credito Totale Insufficiente \n-");

  }

  private static void insCodice() {
    System.out.print("\nInserire il codice prodotto: "); codice = in.nextInt();
  }

  private static void calcolaResto() {
    Distributore.decProdotto(codice);
    Distributore.addIntroito(Distributore.getProdotto(codice, 0).getPrezzo());
    Distributore.setCreditoUtente(0);
  }

  private static void creazioneProdotti() {
    prodotto = new Prodotto("Acqua", 0.50, 0, 0); Distributore.addProdotto(prodotto);
    prodotto = new Prodotto("Patatine", 1, 1, 4); Distributore.addProdotto(prodotto);
    prodotto = new Prodotto("Coca Cola", 0.70, 2, 6); Distributore.addProdotto(prodotto);
    prodotto = new Prodotto("Acqua Frizzante", 0.60, 3, 11); Distributore.addProdotto(prodotto);
  }
}