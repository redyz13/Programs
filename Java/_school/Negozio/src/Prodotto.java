public class Prodotto {
    protected String nome;
    protected double prezzo;
    protected int codice, numero;

    public Prodotto(String nome, double prezzo, int codice, int numero) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.codice = codice;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getCodice() {
        return codice;
    }

    public int getNumero() {
        return numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void incProdotto(int qty) {
        numero += qty;
    }

    public boolean decProdotto(int qty) {
        if(this.numero >= qty) {
            numero --;
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "\n- Prodotto n." + getCodice() + " -\n" +
                "\tNome: " + getNome() + "\n" +
                "\tPrezzo: € " + getPrezzo() + "\n" +
                "\tDisponibili: " + getNumero() + "\n";
    }
}