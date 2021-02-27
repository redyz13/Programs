public class Motociclo extends  Veicolo {
  private int cilindrata;

  public Motociclo(String marca, String targa, String modello, boolean stato, int cilindrata) {
    super(marca, targa, modello, stato);
    this.cilindrata = cilindrata;
  }

  public int getCilindrata() {
    return cilindrata;
  }

  public void setCilindrata(int cilindrata) {
    this.cilindrata = cilindrata;
  }

  @Override
  public String toString() {
    return "\n- Motociclo t." + getTarga() + " -\n" +
        "\tMarca: " + getMarca() + "\n" +
        "\tModello: " + getModello() + "\n" +
        "\tStato: " + getStatoString() + "\n" +
        "\tCilindrata: " + getCilindrata() + "\n";
  }
}