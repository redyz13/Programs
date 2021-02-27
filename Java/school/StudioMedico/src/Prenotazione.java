public class Prenotazione {
    private Paziente paziente;
    private int giorno, ora;
    private String codice;

    public Prenotazione(Paziente paziente, String codice, int giorno, int ora) {
        this.paziente = paziente;
        this.codice = codice;
        this.giorno = giorno;
        this.ora = ora;
    }

    public Paziente getPaziente() {
        return paziente;
    }

    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
}