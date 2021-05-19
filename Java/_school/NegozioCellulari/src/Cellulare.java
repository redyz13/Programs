public class Cellulare {
  private String marca, processore;
  private int codice, qty_omem, qty;
  private double ore_autonomia, prezzo;

  public Cellulare(String marca, String processore, int codice, int qty_omem,
                   int qty, double ore_autonomia, double prezzo) {
    this.marca = marca;
    this.processore = processore;
    this.codice = codice;
    this.qty_omem = qty_omem;
    this.qty = qty;
    this.ore_autonomia = ore_autonomia;
    this.prezzo = prezzo;
  }

  public String getMarca() {
    return marca;
  }

  public String getProcessore() {
    return processore;
  }

  public int getCodice() {
    return codice;
  }

  public int getQty_omem() {
    return qty_omem;
  }

  public int getQty() {
    return qty;
  }

  public double getOre_autonomia() {
    return ore_autonomia;
  }

  public double getPrezzo() {
    return prezzo;
  }

  public void addQty(int qty) {
    this.qty = this.qty + qty;
  }

  public int subQty(int qty) {
    if (this.qty > 0) {
      this.qty = this.qty - qty;
      return 0;
    }
    else
      return -1;
  }

  public String toString() {
    return
        "\nMarca = " + getMarca() +
        "\nProcessore = " + getProcessore() +
        "\nCodice = " + getCodice() +
        "\nMemoria = " + getQty_omem() +
        "\nQuantità disponibile = " + getQty() +
        "\nOre Autonomia = " + getOre_autonomia() +
        "\nPrezzo = " + getPrezzo();
  }
}