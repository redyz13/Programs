public class Vettura extends Veicolo {
  private String tipologia;

  public Vettura(String marca, String targa, String modello, boolean stato, String tipologia) {
    super(marca, targa, modello, stato);
    this.tipologia = tipologia;
  }

  public String getTipologia() {
    return tipologia;
  }

  public void setTipologia(String tipologia) {
    this.tipologia = tipologia;
  }

  @Override
  public String toString() {
    return "\n- Vettura t." + getTarga() + " -\n" +
        "\tMarca: " + getMarca() + "\n" +
        "\tModello: " + getModello() + "\n" +
        "\tStato: " + getStatoString() + "\n" +
        "\tTipologia: " + getTipologia() + "\n";
  }
}