public class Prestito {
  private Cliente prestatario;
  private int dataPrestito, dataScadenza, numeroRisconoscimento;
  private Libro libro;

  public Prestito(Cliente prestatario, int dataPrestito, int dataScadenza, Libro libro, int numeroRisconoscimento) {
    this.prestatario = prestatario;
    this.dataPrestito = dataPrestito;
    this.dataScadenza = dataScadenza;
    this.libro = libro;
    this.numeroRisconoscimento = numeroRisconoscimento;
  }

  public Cliente getPrestatario() {
    return prestatario;
  }

  public int getDataPrestito() {
    return dataPrestito;
  }

  public int getDataScadenza() {
    return dataScadenza;
  }

  public Libro getLibro() {
    return libro;
  }

  public int getNumeroRisconoscimento() {
    return numeroRisconoscimento;
  }

  public void setPrestatario(Cliente prestatario) {
    this.prestatario = prestatario;
  }

  public void setDataPrestito(int dataPrestito) {
    this.dataPrestito = dataPrestito;
  }

  public void setDataScadenza(int dataScadenza) {
    this.dataScadenza = dataScadenza;
  }

  public void setLibro(Libro libro) {
    this.libro = libro;
  }

  public void setNumeroRisconoscimento(int numeroRisconoscimento) {
    this.numeroRisconoscimento = numeroRisconoscimento;
  }

  @Override
  public String toString() {
    return "\n- Informazioni Prestito n. " + getNumeroRisconoscimento() + " -\n" +
        "\tPrestatario: " + getPrestatario() + "\n" +
        "\tData presito " + getDataPrestito() + "\n" +
        "\tData scadenza: " + getDataScadenza() + "\n" +
        "\tLibro: " + getLibro();
  }
}