public class Prodotto {
  private String nome;
  private double prezzo;
  private int codice, numero;

  public Prodotto(String nome, double prezzo, int codice, int numero) {
    this.nome = nome;
    this.prezzo = prezzo;
    this.codice = codice;
    this.numero = numero;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(double prezzo) {
    this.prezzo = prezzo;
  }

  public int getCodice() {
    return codice;
  }

  public void setCodice(int codice) {
    this.codice = codice;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void incProdotto(int qty) {
    numero += qty;
  }

  public void decProdotto() {
    numero --;
  }

  public String toString() {
    return "\n- Prodotto n." + getCodice() + " -\n" +
        "\tNome: " + getNome() + "\n" +
        "\tPrezzo: € " + getPrezzo() + "\n" +
        "\tDisponibili: " + getNumero() + "\n";
  }
}