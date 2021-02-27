public class Libro {
  private String titolo, autore, editore, isbn;
  private int scadenza;

  public Libro(String titolo, String autore, String editore, String isbn, int scadenza) {
    this.titolo = titolo;
    this.autore = autore;
    this.editore = editore;
    this.isbn = isbn;
    this.scadenza = scadenza;
  }

  public String getTitolo() {
    return titolo;
  }

  public String getAutore() {
    return autore;
  }

  public String getEditore() {
    return editore;
  }

  public String getIsbn() {
    return isbn;
  }

  public int getScadenza() {
    return scadenza;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public void setAutore(String autore) {
    this.autore = autore;
  }

  public void setEditore(String editore) {
    this.editore = editore;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public void setScadenza(int scadenza) {
    this.scadenza = scadenza;
  }

  @Override
  public String toString() {
    return "\n- Dati Libro" + " -\n" +
        "\tTitolo: " + getTitolo() + "\n" +
        "\tAutore: " + getAutore() + "\n" +
        "\tEditore: " + getEditore() + "\n" +
        "\tISBN: " + getIsbn() + "\n";
  }

  public String toStringCopia() {
    return getTitolo() + " di " + getAutore() + "\n" +
        "\tEditore: " + getEditore() + "\n\tISBN: " + getIsbn();
  }
}