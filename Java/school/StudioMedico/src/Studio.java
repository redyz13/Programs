//Created by Bud Spancer & Terence Hill
import java.util.Scanner;

public class Studio {
    private static Scanner in = new Scanner(System.in);
    private static Agenda agenda = new Agenda();
    private static Paziente paziente;
    private static ListaPazienti listaPazienti = new ListaPazienti();
    private static int sceltaMenu, scelta, giorno, ora;
    private static String nome, cognome, codice;

    public static void main(String[] args) {
        do {
            menu();
        }while(sceltaMenu != 0);
    }

    private static void menu() {
        System.out.println("\nSelezionare un opzione\n1. Menu Paziente\n2. Menu Prenotazioni\n0. Esci");
        System.out.print("\nSelezione: ");
        sceltaMenu = in.nextInt();
        switch(sceltaMenu) {
            case 1: menuPaziente(); break;
            case 2: menuPrenotazioni(); break;
            case 0: break;
        }
    }

    private static void menuPaziente() {
        boolean exit = false;
        while(!exit) {
            System.out.println("\n1. Aggiungi Paziente\n2. Rimuovi Paziente\n3. Aggiorna Paziente\n4. Mostra Lista Pazienti" +
                "\n0. Esci");
            System.out.print("\nSelezione: ");
            scelta = in.nextInt();
            switch(scelta) {
                case 1: addPaziente(); break;
                case 2: rmvPaziente(); break;
                case 3: updPaziente(); break;
                case 4: mostraListaPazienti(); break;
                case 0: exit = true; break;
            }
        }
    }

    private static void menuPrenotazioni() {
        boolean exit = false;
        while(!exit) {
            System.out.println("\n1. Aggiungi Prenotazione\n2. Rimuovi Prenotazione\n3. Aggiorna Prenotazioni" +
                "\n4. Mostra Lista Prenotazioni\n0. Esci");
            System.out.print("\nSelezione: ");
            scelta = in.nextInt();
            switch(scelta) {
                case 1: addPrenotazione(); break;
                case 2: rmvPrenotazione(); break;
                case 3: updPrenotazione(); break;
                case 4: mostraListaPrenotazioni(); break;
                case 0: exit = true; break;
            }
        }
    }

    private static void addPaziente() {
        System.out.print("\n- Aggiunta Paziente -\n");
        System.out.print("Inserire il nome: "); nome = in.next();
        System.out.print("Inserire il cognome: "); cognome = in.next();
        System.out.print("Inserire il codice paziente: "); codice = in.next();

        paziente = new Paziente(nome, cognome, codice);
        listaPazienti.addPaziente(paziente);
        System.out.print("\n- Paziente Aggiunto -\n");
    }

    private static void rmvPaziente() {
        insCodice();
        if(listaPazienti.rmvPaziente(codice) == 0)
            System.out.print("\n- Paziente Rimosso -\n");
        else
            System.out.print("\n- Operazione non riuscita -\n");
    }

    private static void updPaziente() {
        do {
            System.out.println("\n1. Modifica Nome\n2. Modifica Cognome\n3. Modifica Codice\n0. Esci");
            System.out.print("\nSelezione: ");
            scelta = in.nextInt();

            switch(scelta) {
                case 1: setNome(); break;
                case 2: setCognome(); break;
                case 3: setCodice(); break;
            }
        }while(scelta != 0);
    }

    private static void setNome() {
        insCodice();
        System.out.print("\nInserire il nome: "); nome = in.next();
        listaPazienti.getPaziente(codice).setNome(nome);
        System.out.print("\n- Nome Aggiornato -\n");
    }

    private static void setCognome() {
        insCodice();
        System.out.print("\nInserire il cognome: "); cognome = in.next();
        listaPazienti.getPaziente(codice).setCognome(cognome);
        System.out.print("\n- Cognome Aggiornato -\n");
    }

    private static void setCodice() {
        insCodice();
        System.out.print("\nInserire il codice: "); codice = in.next();
        listaPazienti.getPaziente(codice).setCodice(codice);
        System.out.print("\n- Codice Aggiornato -\n");
    }

    private static void mostraListaPazienti() {
        listaPazienti.mostraListaPazienti();
    }

    private static void addPrenotazione() {
        insCodice();
        System.out.print("Inserire il giorno della prenotazione: "); giorno = in.nextInt();
        System.out.print("Inserire il l'ora della prenotazione: "); ora = in.nextInt();
        agenda.addPrenotazione(listaPazienti.getPaziente(codice), codice, giorno, ora);
        System.out.print("\n- Prenotazione Aggiunta -\n");
    }

    private static void rmvPrenotazione() {
        if(agenda.rmvPrenotazione(codice) == 0)
            System.out.print("\n- Prenotazione Rimossa -\n");
        else
            System.out.print("\n- Operazione non riuscita -\n");
    }

    private static void updPrenotazione() {
        do {
            System.out.println("\n1. Modifica Giorno\n2. Modifica Ora\n3. Modifica Codice\n0. Esci");
            System.out.print("\nSelezione: ");
            scelta = in.nextInt();

            switch(scelta) {
                case 1: setGiorno(); break;
                case 2: setOra(); break;
                case 3: setCodice(); break;
            }
        }while(scelta != 0);
    }

    private static void setGiorno() {
        insCodice();
        System.out.print("\nInserire il giorno: "); giorno = in.nextInt();
        agenda.getPrenotazione(codice).setGiorno(giorno);
        System.out.print("\n- Giorno Aggiornato -\n");
    }

    private static void setOra() {
        insCodice();
        System.out.print("\nInserire l'ora: "); ora = in.nextInt();
        agenda.getPrenotazione(codice).setOra(ora);
        System.out.print("\n- Ora Aggiornata -\n");
    }

    private static void mostraListaPrenotazioni() {
        agenda.mostraListaPrenotazioni();
    }

    private static void insCodice() {
        System.out.print("\nInserire il codice paziente: "); codice = in.next();
    }
}