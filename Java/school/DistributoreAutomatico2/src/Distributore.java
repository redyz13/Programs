public class Distributore {

  ListaProdotti l = new ListaProdotti();
  double credito = 0;
  double creditoDistributore = 0;
  public Distributore() {}

  public void getProdotti() {
    l.getAllString();
    creditoDistributore = 100;
  }

  public void addCredito(double credito) {
    this.credito += credito;
  }

  public void compraProdotto(int codice, double credito) {
    if (l.getProdotto(codice) != null) {
      if(l.getProdotto(codice).getPrezzo() <= credito) {
        this.credito = credito - l.getProdotto(codice).getPrezzo();
        l.getProdotto(codice).decProdotto();
       if(creditoDistributore >= this.credito) {
         System.out.print("Prodotto acquistato, resto: " + this.credito);
         this.creditoDistributore -= this.credito;
       }
       else
         System.err.print("Resto non disponibile, ripassa domani");
      }
    }
    else {
      System.err.print("Error");
    }
  }

  /* private static void rifornisciProdotti() {
    System.out.print("\nSelezionare il prodotto in base al codice: "); codice = in.nextInt();
    if(Distributore.getProdotto(codice, 1) != null) {
      System.out.print("\nInserire la quantità del prodotto da aggiungere: "); qty = in.nextInt();
      if(Distributore.incProdotto(codice, qty) == 0)
        System.out.print("\n- Prodotto Rifornito -\n");
    }
    else
      Distributore.getStringProdotto(codice);
  } */

  public void rifornimento(int codice, int qty) {
    if (l.getProdotto(codice) != null) {
        l.AddQty(codice, qty);
    }
    else {
      System.err.print("Error");
    }
  }

  public double getCredito() {
    return credito;
  }

  public double getCreditoDistributore() {
    return creditoDistributore;
  }

  public void setCreditoDistributore(double creditoDistributore) {
    this.creditoDistributore = creditoDistributore;
  }

}