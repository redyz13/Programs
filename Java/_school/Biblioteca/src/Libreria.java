public class Libreria {
  private Copia[] copie;
  private int numeroCopie;

  public Libreria() {
    copie = new Copia[100];
    numeroCopie = 0;
  }

  public int getNumeroCopie() {
    return numeroCopie;
  }

  public void setNumeroCopie(int numeroCopie) {
    this.numeroCopie = numeroCopie;
  }

  public void addCopia(Copia copia) {
    copie[numeroCopie] = copia;
    numeroCopie ++;
  }

  public void visualizzaCopie() {
    for(int i = 0; i < numeroCopie; i ++)
      System.out.print(copie[i]);
  }

  public Copia getCopia(int numeroCopia) {
    Copia copia = null;
    for(int i = 0; i < numeroCopie; i++)
      if(numeroCopia == copie[i].getNumeroCopia()) {
        copia = copie[i];
        break;
      }
    return copia;
  }

  public Copia getCopiaPL(String isbn) {
    Copia copia = null;
    for(int i = 0; i < numeroCopie; i ++)
      if(isbn.equals(copie[i].getIsbn())) {
        copia = copie[i];
        break;
      }
    return copia;
  }

  public Copia getCopiaDisponibile(String isbn) {
    Copia copia = null;
    for(int i = 0; i < numeroCopie; i ++)
      if(isbn.equals(copie[i].getIsbn())) {
        if(copie[i].isPrestato()) {
          copia = copie[i];
          break;
        }
      }
    return copia;
  }

  public boolean removeCopia(int numeroCopia) {
    Copia copia = getCopia(numeroCopia);
    if(copia != null) {
      int i = getObjectIndex(numeroCopia);
      for(int j = i + 1; j < numeroCopie; j ++)
        copie[j - 1] = copie[j];
      numeroCopie --;
      return true;
    }
    return false;
  }

  public void removeCopiePL(String s) {
    for(int i = 0; i < numeroCopie; i ++) {
      if(copie[i].getIsbn().equals(s))
        removeCopia(copie[i].getNumeroCopia());
    }
  }

  private int getObjectIndex(int numeroCopia) {
    for(int i = 0; i < numeroCopie; i ++)
      if(copie[i].getNumeroCopia() == numeroCopia)
        return i;
    return -1;
  }
}