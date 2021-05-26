import java.sql.Date;

public class Carta {
	private int codiceCarta;
	private String numero;
	private int pin, ccv;
	private Date dataScadenza, dataCreazione;
	private int saldo, codiceTitolare;
	private RandomGenerator randomGenerator = new RandomGenerator();
	
	public Carta(String numero, int pin, int ccv,
			Date dataScadenza, Date dataCreazione, int saldo, int codiceTitolare) {
		super();
		this.codiceCarta = Integer.parseInt(randomGenerator.getNumeroCasuale(4));
		this.numero = numero;
		this.pin = pin;
		this.ccv = ccv;
		this.dataScadenza = dataScadenza;
		this.dataCreazione = dataCreazione;
		this.saldo = saldo;
		this.codiceTitolare = codiceTitolare;
	}

	public int getCodiceCarta() {
		return codiceCarta;
	}

	public void setCodiceCarta(int codiceCarta) {
		this.codiceCarta = codiceCarta;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	
	public int getCodiceTitolare() {
		return codiceTitolare;
	}

	public void setCodiceTitolare(int codiceTitolare) {
		this.codiceTitolare = codiceTitolare;
	}

	@Override
	public String toString() {
		return "Carta [codiceCarta=" + codiceCarta + ", numero=" + numero + ", pin=" + pin + ", ccv=" + ccv + ", saldo="
				+ saldo + ", dataScadenza=" + dataScadenza + ", dataCreazione=" + dataCreazione + ", codiceTitolare="
				+ codiceTitolare + "]";
	}
}