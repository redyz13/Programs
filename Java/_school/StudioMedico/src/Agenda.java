public class Agenda {
    private Prenotazione prenotazioni[];
    private int numPrenotazione;

    public Agenda() {
        prenotazioni = new Prenotazione[100];
        numPrenotazione = 0;
    }

    public Prenotazione getPrenotazione(String codice) {
        Prenotazione prenotazione = null;

        for(int i = 0; i < numPrenotazione; i ++)
            if(codice == prenotazioni[i].getCodice()) {
                prenotazione = prenotazioni[i];
                break;
            }
        return prenotazione;
    }

    public void addPrenotazione(Paziente paziente, String codice, int giorno, int ora) {
        prenotazioni[numPrenotazione] = new Prenotazione(paziente, codice, giorno, ora);
        numPrenotazione ++;
    }

    public int rmvPrenotazione(String codice) {
        int idx;
        Prenotazione prenotazione = getPrenotazione(codice);
        if(prenotazione != null) {
            idx = getIdx(prenotazione);
            for(int j = idx + 1; j < numPrenotazione; j ++)
                prenotazioni[j - 1] = prenotazioni[j];
            numPrenotazione --;
            return 0;
        }
        return -1;
    }

    private int getIdx(Prenotazione prenotazione) {
        for(int i = 0; i < numPrenotazione; i ++)
            if(prenotazione.getCodice() == prenotazioni[i].getCodice())
                return i;
        return 0;
    }

    public void mostraListaPrenotazioni() {
        /*for(int i = 0; i < numPrenotazione; i ++)
            System.out.print("\nGiorno: " + Prenotazione.getGiorno()) + "\nOra: " +
                Prenotazione.getOra() + "\nCodice: " + System.out.print(Prenotazione.getCodice());

         */
    }
}