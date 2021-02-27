import java.util.Scanner;
public class Biblioteca {
  private Scanner in = new Scanner(System.in);
  private Catalogo catalogo = new Catalogo();
  private Libreria libreria = new Libreria();
  private ListaPrestiti listaPrestiti = new ListaPrestiti();
  private Libro libro;
  private Copia copia;
  private Prestito prestito;
  private Cliente cliente;
  private int numeroCopia;

  public static void main(String[] args) {
    Biblioteca b = new Biblioteca();
    b.menu();
  }

  public void menu() {
    creazioneLibri();
    int s;
    do {
      System.out.println("\nSelezionare un opzione\n1. Menu Utente\n2. Menu Gestione\n0. Esci");
      System.out.print("\nSelezione: ");
      s = in.nextInt();
      switch(s) {
        case 1: menuUtente();break;
        case 2: menuGestione();
        case 0: break;
      }
    }while(s != 0);
  }

  private void menuUtente() {
    int scelta;
    do {
      System.out.println("\n1. Visualizza libri dal catalogo\n2. Cerca libri nel catalogo" +
          "\n3. Prendi libro in prestito\n0. Esci");
      System.out.print("\nSelezione: ");
      scelta = in.nextInt();
      switch(scelta) {
        case 1: visualizzaLibri(); break;
        case 2: cercaLibro(); break;
        case 3: prestaLibro() ; break;
        case 0: break;
      }
    } while(scelta != 0);
  }

  private void menuGestione() {
    int scelta;
    do {
      System.out.println("\n1. Aggiungi libro al catalogo\n2. Rimuovi libro da catalogo" +
          "\n3. Visualizza copie libro\n4. Rifornisci copie libro\n5. Rimuovi copie libro" +
          "\n6. Visualizza prestiti\n0. Esci");
      System.out.print("\nSelezione: ");
      scelta = in.nextInt();
      switch(scelta) {
        case 1: aggiungiLibro(); break;
        case 2: rimuoviLibro(); break;
        case 3: visualizzaCopie(); break;
        case 4: rifornisciCopie() ; break;
        case 5: rimuoviCopie(); break;
        case 6: visualizzaPrestiti(); break;
        case 0: break;
      }
    } while(scelta != 0);
  }

  private void visualizzaLibri() {
    catalogo.visualizzaLibri();
  }

  private void cercaLibro() {
    int scelta;
    do {
      System.out.println("\n1. Ricerca per nome\n2. Visualizza libri per autore" +
          "\n3. Cerca con ISBN\n0. Esci");
      System.out.print("\nSelezione: ");
      scelta = in.nextInt();
      switch(scelta) {
        case 1: ricercaNome();break;
        case 2: libriAutore();break;
        case 3: ricercaIsbn();break;
        case 0: break;
      }
    } while(scelta != 0);
  }

  private void ricercaNome() {
    String s;
    System.out.print("\nInserisci il titolo del libro: "); s = in.nextLine(); s = in.nextLine();
    libro = catalogo.cercaLibroTitolo(s);
    if(libro != null)
      System.out.print(libro);
    else
      System.out.print("\n- Libro non trovato -\n");
  }

  private void libriAutore() {
    String s, r;
    System.out.print("\nInserisci il nome dell'autore: "); s = in.nextLine(); s = in.nextLine();
    r = catalogo.cercaLibroAutore(s);
    if(!r.equals(""))
      System.out.print(r);
    else
      System.out.print("\n- Nessun libro trovato -\n");
  }

  private void ricercaIsbn() {
    String s;
    System.out.print("\nInserisci il codice ISBN: "); s = in.nextLine(); s = in.nextLine();
    libro = catalogo.getLibro(s);
    if(libro != null)
      System.out.print(libro);
    else
      System.out.print("\n- Libro non trovato -\n");
  }

  private void prestaLibro() {
    String s, nome, cognome, codiceFiscale;
    int dataPrestito, numeroRiconoscimento;
    System.out.print("\nInserisci il codice ISBN: "); s = in.nextLine(); s = in.nextLine();
    libro = catalogo.getLibro(s);
    copia = libreria.getCopiaDisponibile(s);
    if(libro == null)
      System.out.print("\n- Libro non trovato -\n");
    else if(libreria.getCopiaPL(s) == null && libreria.getCopiaDisponibile(s) == null) {
      System.out.print("\n- Nessuna copia disponibile -\n");
    }
    else {
      System.out.print("\n- Inserizione Dati -\n");
      System.out.print("\tInserire il nome: "); nome = in.nextLine();
      System.out.print("\tInserire il cognome: "); cognome = in.nextLine();
      System.out.print("\tInserire il codice fiscale: "); codiceFiscale = in.nextLine();
      System.out.print("\tInserire la data di prestito: "); dataPrestito = in.nextInt();
      System.out.print("\tInserire un numero di riconoscimento: "); numeroRiconoscimento = in.nextInt();
      cliente = new Cliente(nome, cognome, codiceFiscale);
      prestito = new Prestito(cliente, dataPrestito, libro.getScadenza(), libro, 0);
      copia.setPrestato(true);
      listaPrestiti.addPrestito(prestito);
      System.out.print("\n- Libro prestato -\n");
    }
  }

  private void aggiungiLibro() {
    String titolo, autore, editore, isbn;
    int scadenza;
    System.out.print("\n- Inserizione Dati -\n");
    System.out.print("\tTitolo: "); titolo = in.nextLine(); titolo = in.nextLine();
    System.out.print("\tAutore: "); autore = in.nextLine();
    System.out.print("\tEditore: "); editore = in.nextLine();
    System.out.print("\tData scadenza: "); scadenza = in.nextInt();
    do {
      System.out.print("\tISBN: "); isbn = in.nextLine();
      if(catalogo.verIsbns(isbn))
        System.out.print("\n-Codice ISBN già esistente -\n");
    }while(catalogo.verIsbns(isbn));
    libro = new Libro(titolo, autore, editore, isbn, scadenza);
    catalogo.addLibro(libro);
    System.out.print("\n- Libro aggiunto -\n");
  }

  private void rimuoviLibro() {
    String s;
    System.out.print("\nInserisci il codice ISBN: "); s = in.nextLine(); s = in.nextLine();
    if(catalogo.removeLibro(s)) {
      libreria.removeCopiePL(s);
      System.out.print("\n- Libro ed eventuali copie rimosse -\n");
    }
    else
      System.out.print("\n- Libro non trovato -\n");
  }

  private void visualizzaCopie() {
    libreria.visualizzaCopie();
  }

  private void rifornisciCopie() {
    String s, c;
    double prezzo;
    int scadenza;
    System.out.print("\nSelezionare un libro dal catalogo tramite ISBN: "); s = in.nextLine(); s = in.nextLine();
    libro = catalogo.getLibro(s);
    if(libro != null) {
      do {
        System.out.print("Inserire il prezzo da assegnare alla copia: "); prezzo = in.nextDouble();
      }while(prezzo <= 0);
      System.out.print("Inserire dettagli sulle condizioni della copia: "); c = in.nextLine(); c = in.nextLine();
      copia = new Copia(libro, prezzo, c, numeroCopia ++, false);
      libreria.addCopia(copia);
      System.out.println("\n- Copia aggiunta -");
    }
    else
      System.out.print("\n- Libro non trovato -\n");
  }

  private void rimuoviCopie() {
    String s;
    int c;
    System.out.print("\nSelezionare un libro dal catalogo tramite ISBN: "); s = in.nextLine(); s = in.nextLine();
    libro = catalogo.getLibro(s);
    if(libro != null) {
      System.out.print("\nInserire il numero della copia da rimuovere: "); c = in.nextInt();
      copia = libreria.getCopia(c);
      if(copia != null && copia.getLibro().getIsbn().equals(libro.getIsbn())) {
        libreria.removeCopia(c);
        System.out.print("\n- Copia rimossa -\n");
      }
      else
        System.out.print("\n- Copia non trovata -\n");
    }
    else
      System.out.print("\n- Libro non trovato -\n");
  }

  private void visualizzaPrestiti() {
    listaPrestiti.visualizzaPrestiti();
  }

  private void creazioneLibri() {
    String s = "";
    boolean x = true;
    for(int i = 0; i < 5; i++) {
      if(i % 2 == 0)
        s = "Nuovo";
      else
        s = "Usato";
      x ^= true;
      libro = new Libro("Titolo" + i, "Autore" + i, "Editore" + i, Integer.toString(i), (i + 1) * 2);
      catalogo.addLibro(libro);
      copia = new Copia(libro, (i + 1) * 2, s, numeroCopia ++, x);
      libreria.addCopia(copia);
    }

    libro = new Libro("Divina Commedia" , "Dante Alighieri", "Dante", Integer.toString(21), 4);
    catalogo.addLibro(libro);
    for(int i = 0; i < 3; i ++) {
      x ^= true;
      copia = new Copia(libro, 30, "Nuovo", numeroCopia ++, x);
      libreria.addCopia(copia);
    }
    libro = new Libro("Vita Nuova" , "Dante Alighieri", "Dante", Integer.toString(22), 4);
    catalogo.addLibro(libro);
    for(int i = 0; i < 2; i ++) {
      x ^= true;
      copia = new Copia(libro, 25, "Usato", numeroCopia ++, x);
      libreria.addCopia(copia);
    }
    libro = new Libro("Monarchia" , "Dante Alighieri", "Dante", Integer.toString(23), 6);
    catalogo.addLibro(libro);
    for(int i = 0; i < 2; i ++) {
      x ^= true;
      copia = new Copia(libro, 10, "Nuovo", numeroCopia ++, x);
      libreria.addCopia(copia);
    }
    libro = new Libro("Convivio" , "Dante Alighieri", "Dante", Integer.toString(24), 7);
    catalogo.addLibro(libro);
    for(int i = 0; i < 2; i ++) {
      x ^= true;
      copia = new Copia(libro, 25, "Nuovo", numeroCopia ++, x);
      libreria.addCopia(copia);
    }
    libro = new Libro("De Vulgari Eloquentia" , "Dante Alighieri", "Dante", Integer.toString(25), 9);
    catalogo.addLibro(libro);
    for(int i = 0; i < 2; i ++) {
      x ^= true;
      copia = new Copia(libro, 15, "Usato", numeroCopia++, true); // Set x over true
      libreria.addCopia(copia);
    }
  }
}