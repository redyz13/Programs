public class Veicolo {
  protected String marca, targa, modello;
  protected boolean stato;

  public Veicolo(String marca, String targa, String modello, boolean stato) {
    this.marca = marca;
    this.targa = targa;
    this.modello = modello;
    this.stato = stato;
  }

  public String getMarca() {
    return marca;
  }

  public String getTarga() {
    return targa;
  }

  public String getModello() {
    return modello;
  }

  public boolean getStato() {
    return stato;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setTarga(String targa) {
    this.targa = targa;
  }

  public void setModello(String modello) {
    this.modello = modello;
  }

  public void setStato(boolean stato) {
    this.stato = stato;
  }

  @Override
  public String toString() {
    return "\n- Veicolo t." + getTarga() + " -\n" +
        "\tMarca: " + getMarca() + "\n" +
        "\tModello: " + getModello() + "\n" +
        "\tStato: " + getStatoString() + "\n";
  }

  public String getStatoString() {
    if(getStato())
      return "Veicolo Riparato";
    else
      return "Veicolo Guasto";
  }
}