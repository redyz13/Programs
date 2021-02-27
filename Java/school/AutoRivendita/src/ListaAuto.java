public class ListaAuto {
  private Auto[] autoa;
  private int numeroAuto;

  public ListaAuto() {
    autoa = new Auto[100];
    numeroAuto = 0;
  }

  public void addObject(Auto auto) {
    autoa[numeroAuto] = auto;
    numeroAuto ++;
  }

  public Auto getObject(String targa) {
    Auto auto = null;
    for(int i = 0; i < numeroAuto; i++)
      if (targa.equals(autoa[i].getTarga())) {
        auto = autoa[i];
        break;
      }
    return auto;
  }

  public void visualizzaObject() {
    for(int i = 0; i < numeroAuto; i ++)
      System.out.print(autoa[i]);
  }

  public boolean removeAuto(String targa) {
    Auto auto = getObject(targa);
    if(auto != null) {
      int i = getObjectIndex(targa);
      for(int j = i + 1; j < numeroAuto; j ++)
        autoa[j - 1] = autoa[j];
      numeroAuto --;
      return true;
    }
    return false;
  }

  private int getObjectIndex(String targa) {
    for(int i = 0; i < numeroAuto; i ++)
      if(autoa[i].getTarga().equals(targa))
        return i;
    return -1;
  }
}