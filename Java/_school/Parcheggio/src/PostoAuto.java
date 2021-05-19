public class PostoAuto extends Posto {
  private String targa;

  public PostoAuto(int numero, double tariffa) {
    super(numero, tariffa);
    targa = "";
  }

  public String getTarga() {
    return targa;
  }

  public void setTarga(String targa) {
    this.targa = targa;
  }
}