public class VerificaScritta extends  Verifica {
  private String traccia;
  private int durataProva;

  public VerificaScritta(double voto, int data, String materia, String traccia, int durataProva) {
    super(voto, data, materia);
    this.traccia = traccia;
    this.durataProva = durataProva;
  }

  public String getTraccia() {
    return traccia;
  }

  public int getDurataProva() {
    return durataProva;
  }

  public void setTraccia(String traccia) {
    this.traccia = traccia;
  }

  public void setDurataProva(int durataProva) {
    this.durataProva = durataProva;
  }

  @Override
  public String toString() {
    String s = super.toString();
    s += "\tTraccia: " + getTraccia() + "\n" +
         "\tDurata Prova: " + getDurataProva() + "\n";
    return s;
  }
}