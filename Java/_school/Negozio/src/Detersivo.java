public class Detersivo extends Prodotto {
    private int gradoInquinamento;

    public Detersivo(String nome, double prezzo, int codice, int numero, int gradoInquinamento) {
        super(nome, prezzo, codice, numero);
        this.gradoInquinamento = gradoInquinamento;
    }

    public int getGradoInquinamento() {
        return gradoInquinamento;
    }

    public void setGradoInquinamento(int gradoInquinamento) {
        this.gradoInquinamento = gradoInquinamento;
    }

    @Override
    public String toString() {
        return "\n- Detersivo n." + getCodice() + " -\n" +
                "\tNome: " + getNome() + "\n" +
                "\tPrezzo: € " + getPrezzo() + "\n" +
                "\tGrado Inquinamento: " + getGradoInquinamento() + "\n" +
                "\tDisponibili: " + getNumero() + "\n";
    }
}