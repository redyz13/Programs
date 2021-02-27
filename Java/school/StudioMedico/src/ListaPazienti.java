public class ListaPazienti {
    private Paziente[] pazienti;
    private int numPaziente;

    public ListaPazienti() {
        pazienti = new Paziente[100];
        numPaziente = 0;
    }

    public Paziente getPaziente(String codice) {
        Paziente paziente = null;
        for(int i = 0; i < numPaziente; i ++)
            if(codice == pazienti[i].getCodice()) {
                paziente = pazienti[i];
                break;
            }
        return paziente;
    }

    public void addPaziente(Paziente paziente) {
        pazienti[numPaziente] = paziente;
        numPaziente ++;
    }

    public int rmvPaziente(String codice) {
        int idx;
        Paziente paziente = getPaziente(codice);
        if(paziente != null) {
            idx = getIdx(paziente);
            for(int j = idx + 1; j < numPaziente; j ++)
                pazienti[j - 1] = pazienti[j];
            numPaziente --;
            return 0;
        }
        return -1;
    }

    private int getIdx(Paziente paziente) {
        for(int i = 0; i < numPaziente; i ++)
            if(paziente.getCodice() == this.pazienti[i].getCodice())
                return i;
        return 0;
    }

    public void mostraListaPazienti() {
        /*for(int i = 0; i < numPaziente; i ++)
            System.out.print("\nNome: " + Paziente.getNome()) + "\nCognome: " +
                Paziente.getCognome() + "\nCodice: " + System.out.print(Paziente.getCodice());

         */
    }
}