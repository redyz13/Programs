public class Alunno {
  private String nome, cognome, classe;
  private Verifica[] verifiche;
  private int numeroVerifiche, codiceAlunno;

  public Alunno(String nome, String cognome, int codiceAlunno) {
    this.nome = nome;
    this.cognome = cognome;
    this.codiceAlunno = codiceAlunno;
    verifiche = new Verifica[10];
    numeroVerifiche = 0;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public int getCodiceAlunno() {
    return codiceAlunno;
  }

  public int getNumeroVerifiche() {
    return numeroVerifiche;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setCodiceAlunno(int codiceAlunno) {
    this.codiceAlunno = codiceAlunno;
  }

  public void setNumeroVerifiche(int numeroVerifiche) {
    this.numeroVerifiche = numeroVerifiche;
  }

  public Verifica getVerifica(String nome) {
    Verifica verifica = null;
    for(int i = 0; i < numeroVerifiche; i ++)
      if(nome.equals(verifiche[i].getMateria())) {
        verifica = verifiche[i];
        break;
      }
    return verifica;
  }

  public double getVotoMedio(String materia) {
    double m = 0;
    int n = 0;
    for(int i = 0; i < numeroVerifiche; i ++)
      if(verifiche[i].getMateria().equals(materia)) {
        m += verifiche[i].getVoto();
        n ++;
      }
    return m / n;
  }

  public double getMediaVerifiche() {
    double m = 0;
    int i;
    for(i = 0; i < numeroVerifiche; i ++)
      m += verifiche[i].getVoto();
    return m / i;
  }

  public void addVerifica(Verifica verifica) {
    verifiche[numeroVerifiche] = verifica;
    numeroVerifiche ++;
  }

  public void visualizzaVerifiche() {
    for(int i = 0; i < numeroVerifiche; i ++)
      System.out.print(verifiche[i]);
  }

  public void visualizzaVerifiche(String materia) {
    for(int i = 0; i < numeroVerifiche; i ++)
      if(verifiche[i].getMateria().equals(materia))
        System.out.print(verifiche[i]);
  }

  @Override
  public String toString() {
    return "\n- Alunno n." + getCodiceAlunno() + " -\n" +
        "\tNome: " + getNome() + "\n" +
        "\tCognome: " + getCognome() + "\n";
  }

  public String toStringMedia() {
    String s = toString();
    s += "\tMedia: " + getMediaVerifiche() + "\n";
    return s;
  }
}