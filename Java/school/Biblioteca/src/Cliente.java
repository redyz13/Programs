public class Cliente {
  private String nome, cognome, codiceFiscale;

  public Cliente(String nome, String cognome, String codiceFiscale) {
    this.nome = nome;
    this.cognome = cognome;
    this.codiceFiscale = codiceFiscale;
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

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }

  public String toString() {
    return "\n- Informazioni Prestatario" + " -\n" +
        "\tNome: " + getNome() + "\n" +
        "\tCognome " + getCognome() + "\n" +
        "\tCodice Fiscale: " + getCodiceFiscale();
  }
}