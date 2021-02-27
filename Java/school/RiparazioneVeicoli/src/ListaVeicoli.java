public class ListaVeicoli {
  private Veicolo[] veicoli;
  private int numeroVeicoli;

  public ListaVeicoli() {
    veicoli = new Veicolo[30];
    numeroVeicoli = 0;
  }

  public void addObject(Veicolo veicolo) {
    veicoli[numeroVeicoli] = veicolo;
    numeroVeicoli ++;
  }

  public Veicolo getObject(String targa) {
    Veicolo veicolo = null;
    for (int i = 0; i < numeroVeicoli; i++)
      if (targa.equals(veicoli[i].getTarga())) {
        veicolo = veicoli[i];
        break;
      }
    return veicolo;
  }

  public void visualizzaObject() {
    for(int i = 0; i < numeroVeicoli; i ++)
      System.out.print(veicoli[i]);
  }

  public void visualizzaGuasti() {
    for(int i = 0; i < numeroVeicoli; i ++)
      if(!veicoli[i].getStato())
        System.out.print(veicoli[i]);
  }

  public void visualizzaRiparati() {
    for(int i = 0; i < numeroVeicoli; i ++)
      if(veicoli[i].getStato())
        System.out.print(veicoli[i]);
  }
}