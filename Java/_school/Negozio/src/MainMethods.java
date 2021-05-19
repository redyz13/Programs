import java.util.Scanner;
public class MainMethods {
    Scanner in = new Scanner(System.in);
    ListaProdotti listaProdotti = new ListaProdotti();
    private Prodotto prodotto;
    private ProdottoAlimentare prodottoAlimentare;
    private Detersivo detersivo;
    int codice, numero, dataScadenza, scelta, gradoInquinamento;
    String nome;
    double prezzo;

    public void menu() {
        creazioneProdotti();
        int sceltaMenu;
        do {
            System.out.println("\n1. Visualizza Prodotti\n2. Visualizza Alimentari" +
                "\n3. Visualizza Detersivi\n4. Aggiungi Prodotto\n5. Rimuovi Prodotto" +
                "\n0. Esci");
            System.out.print("\nSelezione: ");
            sceltaMenu = in.nextInt();
            switch(sceltaMenu) {
                case 1: stampaListaProdotti(); break;
                case 2: stampaListaAlimentari(); break;
                case 3: stampaListaDetersivi(); ; break;
                case 4: aggiungiProdotto(); break;
                case 5: rimuoviProdotto(); break;
                case 0: break;
            }
        }while(sceltaMenu != 0);
    }

    private void aggiungiProdotto() {
        selezioneProdotto();
        switch(scelta) {
            case 1: aggiungiProdottoGenerale(); break;
            case 2: aggiungiProdottoAlimentare(); break;
            case 3: aggiungiDetersivo(); break;
        }
    }

    private void aggiungiProdottoGenerale() {
        inserimentoAttributi();
        prodotto = new Prodotto(nome, prezzo, codice, numero);
        listaProdotti.addObject(prodotto);
        System.out.print("\n- Prodotto Aggiunto -\n");
    }

    private void aggiungiProdottoAlimentare() {
        inserimentoAttributi();
        System.out.print("Data Scadenza: "); dataScadenza = in.nextInt();
        prodottoAlimentare = new ProdottoAlimentare(nome, prezzo, codice, numero, dataScadenza);
        listaProdotti.addObject(prodottoAlimentare);
        System.out.print("\n- Prodotto Aggiunto -\n");
    }

    private void aggiungiDetersivo() {
        inserimentoAttributi();
        System.out.print("Grado Inquinamento: "); gradoInquinamento = in.nextInt();
        detersivo = new Detersivo(nome, prezzo, codice, numero, gradoInquinamento);
        listaProdotti.addObject(detersivo);
        System.out.print("\n- Prodotto Aggiunto -\n");
    }

    private void inserisciCodice() {
        do {
            System.out.print("\nCodice Prodotto: "); codice = in.nextInt();
            if(!listaProdotti.verificaCodice(codice))
                System.out.print("\n- Codice già esistente -\n");
        }while(!listaProdotti.verificaCodice(codice));
    }

    private void rimuoviProdotto() {
        System.out.print("\nSelezionare il prodotto in base al codice: "); codice = in.nextInt();
        if(listaProdotti.removeObject(codice))
            System.out.print("\n- Prodotto Rimosso -\n");
        else
            System.out.print("\n- Codice Inesistente -\n");
    }

    private void selezioneProdotto() {
        System.out.println("\nSelezionare il tipo di prodotto:\n1. Generale\n2. Alimentare\n3. Detersivo");
        System.out.print("\nSelezione: "); scelta = in.nextInt();
    }

    private void inserimentoAttributi() {
        inserisciCodice();
        System.out.print("Nome: "); nome = in.next();
        System.out.print("Prezzo € "); prezzo = in.nextDouble();
        System.out.print("Disponibili: "); numero = in.nextInt();
    }

    private void stampaListaProdotti() {
        listaProdotti.visualizzaObject();
    }

    private void stampaListaAlimentari() {
        listaProdotti.visualizzaAlimentari();
    }

    private void stampaListaDetersivi() {
        listaProdotti.visualizzaDetersivi();
    }

    private void creazioneProdotti() {
        int x = 0;
        for (int i = 0; i < 5; i++) {
            prodotto = new Prodotto("Prodotto" + i, (i + 1) * 5, x, i + 2);
            listaProdotti.addObject(prodotto);
            prodottoAlimentare = new ProdottoAlimentare("ProdottoAlimentare" + i, (i + 1) * 4, x + 1, i + 3, i + 10);
            listaProdotti.addObject(prodottoAlimentare);
            detersivo = new Detersivo("Detersivo" + i, (i + 1) * 3, x + 2, i + 4, i + 5);
            listaProdotti.addObject(detersivo);
            x += 3;
        }
    }
}