public class Classe {
  private Alunno[] alunni;
  private int numeroAlunni;

  public Classe() {
    alunni = new Alunno[20];
    numeroAlunni = 0;
  }

  public Alunno getObject(int codiceAlunno) {
    Alunno alunno = null;
    for(int i = 0; i < numeroAlunni; i++)
      if(codiceAlunno == (alunni[i].getCodiceAlunno())) {
        alunno = alunni[i];
        break;
      }
    return alunno;
  }

  public void addObject(Alunno alunno) {
    alunni[numeroAlunni] = alunno;
    numeroAlunni ++;
  }

  public void visualizzaObject() {
    for(int i = 0; i < numeroAlunni; i ++)
      System.out.print(alunni[i]);
  }

  public void visualizzaObjectConMedia() {
    for(int i = 0; i < numeroAlunni; i ++)
      System.out.print(alunni[i].toStringMedia());
  }
}