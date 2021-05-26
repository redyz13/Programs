public class Titolare {
	private int codiceTitolare;
	private String nome, cognome, username, pword, email, indirizzo;
	private RandomGenerator randomGenerator = new RandomGenerator();
	
	public Titolare(String nome, String cognome, String username, String pword,
			String email, String indirizzo) {
		super();
		this.codiceTitolare = Integer.parseInt(randomGenerator.getNumeroCasuale(4));
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.pword = pword;
		this.email = email;
		this.indirizzo = indirizzo;
	}

	public int getCodiceTitolare() {
		return codiceTitolare;
	}

	public void setCodiceTitolare(int codiceTitolare) {
		this.codiceTitolare = codiceTitolare;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return "Titolare [codiceTitolare=" + codiceTitolare + ", nome=" + nome + ", cognome=" + cognome + ", username="
				+ username + ", pword=" + pword + ", email=" + email + ", indirizzo=" + indirizzo + "]";
	}
}