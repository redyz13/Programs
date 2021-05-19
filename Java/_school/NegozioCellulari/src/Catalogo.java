public class Catalogo {
  private Cellulare[] Cellulari;
  private int numeroCellulari, cellulariVenduti;

  public Catalogo() {
    Cellulari = new Cellulare[100];
    numeroCellulari = 0;
    cellulariVenduti = 0;
  }

  public Cellulare[] getCellulari() {
    return Cellulari;
  }

  public Cellulare getCellulare(int codice) {
    Cellulare Cellulare = null;
    for(int i = 0; i < numeroCellulari; i ++)
      if(codice == Cellulari[i].getCodice()) {
        Cellulare = Cellulari[i];
        break;
      }

    return Cellulare;
  }

  public void addCellulare(Cellulare Cellulare) {
    Cellulari[numeroCellulari] = Cellulare;
    numeroCellulari ++;
  }

  public void rmvCellulare(int codice) {
    Cellulare Cellulare;
    Cellulare = getCellulare(codice);

    if(Cellulare != null) {
      int idx = getIndexCellulare(Cellulare, codice);
      for(int j = idx + 1; j < numeroCellulari; j ++)
        Cellulari[j - 1] = Cellulari[j];
      numeroCellulari --;
    }
  }

  public int getIndexCellulare(Cellulare Cellulare, int codice) {
    int flag = -1;

    for (int i = 0; i < numeroCellulari; i++) {
      if (codice == Cellulare.getCodice())
        flag = 1;
    }

    return flag;
  }

  public int vendiCellulare(int codice) {
    int res = -2;

    for(int i = 0; i < numeroCellulari; i ++) {
      if(codice == Cellulari[i].getCodice())
        res = Cellulari[i].subQty(1);
    }

    return res;
  }

  public int getAllQty() {
    int disp = 0;

    for (int i = 0; i < this.numeroCellulari; i++)
      disp = disp + Cellulari[i].getQty();

    return disp;
  }

  public String toString() {
    String s = "\n";

    for(int i = 0; i < numeroCellulari; i ++) {
      if(i == numeroCellulari - 1)
        s += Cellulari[i] + "\n";
      else
        s += Cellulari[i];
    }

    return "--- Catalogo ---\n" + s;
  }
}