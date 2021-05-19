public class Cliente {
  private String nome, cognome, codiceFiscale, numeroCarta, password;
  private int autoAcquistate;
  private double creditoCarta;

  public Cliente(String nome, String cognome, String codiceFiscale, int autoAcquistate,
                 String numeroCarta, double creditoCarta, String password) {
    this.nome = nome;
    this.cognome = cognome;
    this.codiceFiscale = codiceFiscale;
    this.autoAcquistate = autoAcquistate;
    this.numeroCarta = numeroCarta;
    this.creditoCarta = creditoCarta;
    this.password = password;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  public int getAutoAcquistate() {
    return autoAcquistate;
  }

  public String getNumeroCarta() {
    return numeroCarta;
  }

  public double getCreditoCarta() {
    return creditoCarta;
  }

  public String getPassword() {
    return password;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setNumeroCarta(String numeroCarta) {
    this.numeroCarta = numeroCarta;
  }

  public void setCreditoCarta(double creditoCarta) {
    this.creditoCarta = creditoCarta;
  }

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  public void setAutoAcquistate(int autoAcquistate) {
    this.autoAcquistate = autoAcquistate;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "\n- Informazioni Cliente" + " -\n" +
        "\tNome: " + getNome() + "\n" +
        "\tCognome " + getCognome() + "\n" +
        "\tCodice Fiscale: " + getCodiceFiscale() + "\n" +
        "\tAuto acquistate: " + getAutoAcquistate() + "\n" +
        "\tNumero carta: " + getNumeroCarta() + "\n" +
        "\tCredito carta: €" + getCreditoCarta() + "\n" +
        "\tPassword: " + getPassword() + "\n";
  }
}