public class ListaPrestiti {
  private Prestito[] prestiti;
  private int numeroPrestiti;

  public ListaPrestiti() {
    prestiti = new Prestito[100];
    numeroPrestiti = 0;
  }

  public void addPrestito(Prestito prestito) {
    prestiti[numeroPrestiti] = prestito;
    numeroPrestiti ++;
  }

  public Prestito getPrestito(int numeroRiconoscimento) {
    Prestito prestito = null;
    for(int i = 0; i < numeroPrestiti; i++)
      if(numeroRiconoscimento == (prestiti[i].getNumeroRisconoscimento())) {
        prestito = prestiti[i];
        break;
      }
    return prestito;
  }

  public void visualizzaPrestiti() {
    for(int i = 0; i < numeroPrestiti; i ++)
      System.out.print(prestiti[i]);
  }
}
