public class Esercente {
	private int codiceEsercente;
	private String nome, cognome, username, pword;
	private RandomGenerator randomGenerator = new RandomGenerator();

	public Esercente(String nome, String cognome, String username, String pword) {
		super();
		this.codiceEsercente = Integer.parseInt(randomGenerator.getNumeroCasuale(4));
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.pword = pword;
	}

	public int getCodiceEsercente() {
		return codiceEsercente;
	}

	public void setCodiceEsercente(int codiceEsercente) {
		this.codiceEsercente = codiceEsercente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@Override
	public String toString() {
		return "Esercente [codiceEsercente=" + codiceEsercente + ", nome=" + nome + ", cognome=" + cognome
				+ ", username=" + username + ", pword=" + pword + "]";
	}
}