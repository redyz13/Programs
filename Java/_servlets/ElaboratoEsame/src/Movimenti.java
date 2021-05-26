import java.sql.Date;

public class Movimenti {
	private int codiceMovimento, importoTransazione;
	private Date dataTransazione;
	private String descrizione;
	private int codiceCarta;
	private RandomGenerator randomGenerator = new RandomGenerator();
	
	public Movimenti(int importoTransazione, Date dataTransazione, int codiceCarta) {
		super();
		this.codiceMovimento = Integer.parseInt(randomGenerator.getNumeroCasuale(4));
		this.importoTransazione = importoTransazione;
		this.dataTransazione = dataTransazione;
		this.descrizione = randomGenerator.getNumeroCasuale(6);
		this.codiceCarta = codiceCarta;
	}

	public int getCodiceMovimento() {
		return codiceMovimento;
	}

	public void setCodiceMovimento(int codiceMovimento) {
		this.codiceMovimento = codiceMovimento;
	}

	public int getImportoTransazione() {
		return importoTransazione;
	}

	public void setImportoTransazione(int importoTransazione) {
		this.importoTransazione = importoTransazione;
	}

	public Date getDataTransazione() {
		return dataTransazione;
	}

	public void setDataTransazione(Date dataTransazione) {
		this.dataTransazione = dataTransazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getCodiceCarta() {
		return codiceCarta;
	}

	public void setCodiceCarta(int codiceCarta) {
		this.codiceCarta = codiceCarta;
	}

	public RandomGenerator getRandomGenerator() {
		return randomGenerator;
	}

	public void setRandomGenerator(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
	}

	@Override
	public String toString() {
		return "Movimenti [codiceMovimento=" + codiceMovimento + ", importoTransazione=" + importoTransazione
				+ ", dataTransazione=" + dataTransazione + ", descrizione=" + descrizione + ", codiceCarta="
				+ codiceCarta + ", randomGenerator=" + randomGenerator + "]";
	}
}