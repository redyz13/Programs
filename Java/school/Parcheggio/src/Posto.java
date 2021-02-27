public class Posto {
  protected int numero, ora;
  protected double tariffa;
  protected boolean occupato;

  public Posto(int numero, double tariffa) {
    this.numero = numero;
    this.tariffa = tariffa;
    ora = 0;
    occupato = false;
  }

  public int getNumero() {
    return numero;
  }

  public int getOra() {
    return ora;
  }

  public double getTariffa() {
    return tariffa;
  }

  public boolean getOccupato() {
    return occupato;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void setOra(int ora) {
    this.ora = ora;
  }

  public void setTariffa(double tariffa) {
    this.tariffa = tariffa;
  }

  public void setOccupato(boolean occupato) {
    this.occupato = occupato;
  }

  public String getNumeroPostoString() {
    return "\nPosto n. " + Integer.toString(numero);
  }
}