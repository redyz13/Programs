public class Copia {
  private Libro libro;
  private double prezzo;
  private String condizioni;
  private int numeroCopia;
  private boolean prestato;

  public Copia(Libro libro, double prezzo, String condizioni, int numeroCopia, boolean prestato) {
    this.libro = libro;
    this.prezzo = prezzo;
    this.condizioni = condizioni;
    this.numeroCopia = numeroCopia;
    this.prestato = prestato;
  }

  public Libro getLibro() {
    return libro;
  }

  public String getIsbn() {
    return libro.getIsbn();
  }

  public double getPrezzo() {
    return prezzo;
  }

  public String getCondizioni() {
    return condizioni;
  }

  public int getNumeroCopia() {
    return numeroCopia;
  }

  public boolean isPrestato() {
    return prestato;
  }

  public void setPrezzo(double prezzo) {
    this.prezzo = prezzo;
  }

  public void setCondizioni(String condizioni) {
    this.condizioni = condizioni;
  }

  public void setNumeroCopia(int numeroCopia) {
    this.numeroCopia = numeroCopia;
  }

  public void setLibro(Libro libro) {
    this.libro = libro;
  }

  public void setPrestato(boolean prestato) {
    this.prestato = prestato;
  }

  public String toStringPrestato(boolean prestato) {
    if(prestato)
      return "Libro in prestito";
    else
      return "Libro disponibile";
  }

  @Override
  public String toString() {
    return "\n- Informazioni Copia n. " + getNumeroCopia() + " -\n" +
        "\tLibro: " + libro.toStringCopia() + "\n" +
        "\tPrezzo: € " + getPrezzo() + "\n" +
        "\tCondizioni: " + getCondizioni() + "\n" +
        "\tDisponibilità: " + toStringPrestato(prestato) + "\n";
  }
}