public class PostoMoto extends Posto {
  private String tipologia;

  public PostoMoto(int numero, double tariffa) {
    super(numero, tariffa);
    tipologia = "";
  }

  public String getTipologia() {
    return tipologia;
  }

  public void setTipologia(String tipologia) {
    this.tipologia = tipologia;
  }
}