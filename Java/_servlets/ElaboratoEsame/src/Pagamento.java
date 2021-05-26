public class Pagamento {
	private int codicePagamento, importo;
	private int codiceCarta, codiceEsercente;
	private RandomGenerator randomGenerator = new RandomGenerator();
	
	public Pagamento(int importo, int codiceCarta, int codiceEsercente) {
		super();
		this.codicePagamento = Integer.parseInt(randomGenerator.getNumeroCasuale(4));
		this.importo = importo;
		this.codiceCarta = codiceCarta;
		this.codiceEsercente = codiceEsercente;
	}

	public int getCodicePagamento() {
		return codicePagamento;
	}

	public void setCodicePagamento(int codicePagamento) {
		this.codicePagamento = codicePagamento;
	}

	public int getImporto() {
		return importo;
	}

	public void setImporto(int importo) {
		this.importo = importo;
	}

	public int getCodiceCarta() {
		return codiceCarta;
	}

	public void setCodiceCarta(int codiceCarta) {
		this.codiceCarta = codiceCarta;
	}

	public int getCodiceEsercente() {
		return codiceEsercente;
	}

	public void setCodiceEsercente(int codiceEsercente) {
		this.codiceEsercente = codiceEsercente;
	}

	public RandomGenerator getRandomGenerator() {
		return randomGenerator;
	}

	public void setRandomGenerator(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
	}

	@Override
	public String toString() {
		return "Pagamento [codicePagamento=" + codicePagamento + ", importo=" + importo + ", codiceCarta=" + codiceCarta
				+ ", codiceEsercente=" + codiceEsercente + ", randomGenerator=" + randomGenerator + "]";
	}
}