public class Auto {
  private String marca, modello, statoAuto, targa, tipo;
  private int annoi, nproprietari;
  private double kmp, prezzo;

  public Auto(String marca, String modello, String statoAuto,
              String targa, String tipo, int annoi, int nproprietari,
              double kmp, double prezzo) {
    this.marca = marca;
    this.modello = modello;
    this.statoAuto = statoAuto;
    this.targa = targa;
    this.tipo = tipo;
    this.annoi = annoi;
    this.nproprietari = nproprietari;
    this.kmp = kmp;
    this.prezzo = prezzo;
  }

  public String getMarca() {
    return marca;
  }

  public String getModello() {
    return modello;
  }

  public String getStatoAuto() {
    return statoAuto;
  }

  public String getTarga() {
    return targa;
  }

  public String getTipo() {
    return tipo;
  }

  public int getAnnoi() {
    return annoi;
  }

  public int getNproprietari() {
    return nproprietari;
  }

  public double getKmp() {
    return kmp;
  }

  public double getPrezzo() {
    return prezzo;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setModello(String modello) {
    this.modello = modello;
  }

  public void setStatoAuto(String statoAuto) {
    this.statoAuto = statoAuto;
  }

  public void setTarga(String targa) {
    this.targa = targa;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setAnnoi(int annoi) {
    this.annoi = annoi;
  }

  public void setNproprietari(int nproprietari) {
    this.nproprietari = nproprietari;
  }

  public void setKmp(double kmp) {
    this.kmp = kmp;
  }

  public void setPrezzo(double prezzo) {
    this.prezzo = prezzo;
  }

  @Override
  public String toString() {
    return "\n- Auto t." + getTarga() + " -\n" +
        "\tMarca: " + getMarca() + "\n" +
        "\tModello: " + getModello() + "\n" +
        "\tStato: " + getStatoAuto() + "\n" +
        "\tTipo: " + getTipo() + "\n" +
        "\tAnno Immatricolazione: " + getAnnoi() + "\n" +
        "\tNumero di proprietari: " + getNproprietari() + "\n" +
        "\tKm percorsi: " + getKmp() + "\n" +
        "\tPrezzo: " + getPrezzo() + "\n";
  }
}