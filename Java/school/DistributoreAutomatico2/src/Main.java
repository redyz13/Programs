import org.w3c.dom.ls.LSOutput;

import java.util.*;
class Main {

  static Distributore d = new Distributore();
  static int x;
  static Scanner input = new Scanner(System.in);
  static boolean utente = true;
  static boolean operatore = true;
  static int scelta;

  static public void main(String[] args) {

    System.out.print("1. Utente\n2.Operatore");
    x = input.nextInt();
    if (x == 1) {
      utente();
    } else if (x == 2) {
      operatore();
    } else {
      System.err.print("Errore\n");
    }

  }

  static void utente() {
    while (utente) {
      System.out.println("\n1. Visualizza Prodotti\n2. Aggiungi Credito\n3. Visualizza Credito" +
          "\n4. Acquista Prodotto\n0. Esci");
      System.out.print("\nSelezione: ");
      scelta = input.nextInt();
      switch (scelta) {
        case 1:
          visualizzaProdotti();
          break;
        case 2:
          aggiungiCredito();
          break;
        case 3:
          visualizzaCredito();
          break;
        case 4:
          acquistaProdotto();
          break;
        case 0:
          utente = false;
          break;
      }
    }
  }

  static void visualizzaProdotti() {
    d.getProdotti();
  }

  static void aggiungiCredito() {
    System.out.print("Inserisci credito: ");
    double credito = input.nextDouble();
    d.addCredito(credito);

  }

  static void visualizzaCredito() {
    System.out.print(d.getCredito());
  }

  static void acquistaProdotto() {
    System.out.print("Inserisci codice: ");
    int codice = input.nextInt();
    System.out.print("Inserisci credito: ");
    double credito = input.nextDouble();
    d.compraProdotto(codice, credito);
  }

  static void operatore() {
    while (operatore) {
      System.out.println("\n1. Rifornisci Prodotti\n2. Visualizza Prodotti\n3. Rifornisci Credito" +
          "\n4. Visualizza Introito\n5. Ricava Introito \n0. Esci");
      System.out.print("\nSelezione: ");
      scelta = input.nextInt();
      switch (scelta) {
        case 1:
          rifornisciProdotti();
          break;
        case 2:
          visualizzaProdotti();
          break;
        case 3:
          rifornisciCredito();
          break;
        case 4:
          visualizzaIntroito();
          break;
        case 5:
          ricavaIntroito();
          break;
        case 0:
          operatore = true;
          break;
      }
    }
  }

  static void rifornisciProdotti() {
    System.out.print("Inserisci codice:\t");
    int codice = input.nextInt();
    System.out.print("Inserisci quantita:\t");
    int qty = input.nextInt();
    d.rifornimento(codice, qty);
  }

  static void rifornisciCredito() {
    System.out.println("Inserisci credito: ");
    double credito = input.nextDouble();
    d.setCreditoDistributore(d.getCreditoDistributore() + credito);
  }

  static void visualizzaIntroito() {
    System.out.println("Credito distributore: " + d.getCreditoDistributore());
  }

  static void ricavaIntroito() {
    System.out.println("Ricava: ");
    double credito = input.nextDouble();
    d.setCreditoDistributore(d.getCreditoDistributore() - credito);
  }

}