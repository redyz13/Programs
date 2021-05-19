public class Distributore {
  private static double introito, creditoUtente;
  private static Prodotto prodotti[];
  private static int numeroProdotti, codiceOperatore;

  public Distributore() {
    prodotti = new Prodotto[30];
    introito = 100;
    creditoUtente = 0;
    numeroProdotti = 0;
    codiceOperatore = 123;
  }

  public static double getIntroito() {
    return introito;
  }

  public void setIntroito(double introito) {
    Distributore.introito = introito;
  }

  public static void incIntroito(double introito) {
    Distributore.introito += introito;
  }

  public static int decIntroito(double introito) {
    if(Distributore.introito >= introito) {
      Distributore.introito -= introito;
      return 0;
    }
    return -1;
  }

  public static void addIntroito(double introito) {
    Distributore.introito += introito;
  }

  public static double getCreditoUtente() {
    return creditoUtente;
  }

  public static void setCreditoUtente(double creditoUtente) {
    Distributore.creditoUtente = creditoUtente;
  }

  public static void incCreditoUtente(double creditoUtente) {
    Distributore.creditoUtente += creditoUtente;
  }

  public static void decCreditoUtente(double creditoUtente) {
    Distributore.creditoUtente -= creditoUtente;
  }

  public static int getNumeroProdotti() {
    return numeroProdotti;
  }

  public void setNumeroProdotti(int numeroProdotti) {
    Distributore.numeroProdotti = numeroProdotti;
  }

  public static int getCodiceOperatore() {
    return codiceOperatore;
  }

  public static void addProdotto(Prodotto prodotto) {
    prodotti[numeroProdotti] = prodotto;
    numeroProdotti ++;
  }

  public static int incProdotto(int codice, int qty) {
    for(int i = 0; i < numeroProdotti; i ++)
      if(codice == prodotti[i].getCodice()) {
        prodotti[i].incProdotto(qty);
        return 0;
      }
    return -1;
  }

  public static int verProdotto(int codice) {
    for(int i = 0; i < numeroProdotti; i ++)
      if(codice == prodotti[i].getCodice()) {
        return 0;
      }
    return -1;
  }

  public static void decProdotto(int codice) {
    for(int i = 0; i < numeroProdotti; i ++)
      if(codice == prodotti[i].getCodice())
        prodotti[i].decProdotto();
  }

  public static int subProdotto(int codice) {
    int idx;
    Prodotto prodotto = getProdotto(codice, 0);
    if(prodotto != null) {
      idx = getIdx(prodotto);
      for(int j = idx + 1; j < numeroProdotti; j ++)
        prodotti[j - 1] = prodotti[j];
      numeroProdotti --;
      return 0;
    }
    return -1;
  }

  public static int getIdx(Prodotto prodotto) {
    for(int i = 0; i < numeroProdotti; i ++)
      if(prodotto.getCodice() == prodotti[i].getCodice())
        return i;
    return 0;
  }

  public static String getStringProdotto(int codice) {
    String s = "";
    Prodotto prodotto = null;
    for(int i = 0; i < numeroProdotti; i++)
      if(codice == prodotti[i].getCodice() && prodotti[i].getNumero() > 0) {
        prodotto = prodotti[i];
        s = prodotto.toString();
        return s;
      }
      else {
        s = prodottoND(codice);
      }
    return s;
  }

  public static Prodotto getProdotto(int codice, int flag) {
    Prodotto prodotto = null;
    for(int i = 0; i < numeroProdotti; i ++)
      if(codice == prodotti[i].getCodice() && (prodotti[i].getNumero() > 0 || flag == 1)) {
        prodotto = prodotti[i];
        break;
      }
    return prodotto;
  }

  private static String prodottoND(int codice) {
    if(codice < 30)
      return "\n- Prodotto esaurito e non rifornibile -\n";
    else
      return "\n- Prodotto non disponibile -\n";
  }

  public static void visualizzaProdotti() {
    for(int i = 0; i < numeroProdotti; i ++)
      System.out.print(prodotti[i]);
  }
}