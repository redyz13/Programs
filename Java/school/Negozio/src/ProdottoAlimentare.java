public class ProdottoAlimentare extends Prodotto {
    private int dataScadenza;

    public ProdottoAlimentare(String nome, double prezzo, int codice, int numero, int dataScadenza) {
        super(nome, prezzo, codice, numero);
        this.dataScadenza = dataScadenza;
    }

    public int getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(int dataScadenza) {
        this.dataScadenza = dataScadenza;
    }


    @Override
    public String toString() {
        return "\n- Prodotto Alimentare n." + getCodice() + " -\n" +
                "\tNome: " + getNome() + "\n" +
                "\tPrezzo: € " + getPrezzo() + "\n" +
                "\tData Scadenza: " + getDataScadenza() + "\n" +
                "\tDisponibili: " + getNumero() + "\n";
    }
}