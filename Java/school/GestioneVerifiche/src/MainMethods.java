import java.util.Scanner;
public class MainMethods {
  Scanner in = new Scanner(System.in);
  Classe classe = new Classe();
  private Alunno alunno;
  private Verifica verifica;
  private VerificaScritta verificaScritta;
  private int codice;
  private String nome;
  private double media;

  public void menu() {
    creazioneAlunni();
    creazioneVerifiche();
    int sceltaMenu;
    do {
      System.out.println("\n1. Mostra elenco alunni\n2. Elenca verifiche alunno" +
          "\n3. Elenca voto medio materia\n4. Elenca verifiche alunno di una materia" +
          "\n5. Elenca alunni con relativa media verifiche\n0. Esci");
      System.out.print("\nSelezione: ");
      sceltaMenu = in.nextInt();
      switch(sceltaMenu) {
        case 1: elencoAlunni(); break;
        case 2: elencoVerificheAlunno(); break;
        case 3: elencoVotoMedioMateria() ; break;
        case 4: elencoVerificheAlunnoMateria(); break;
        case 5: elencoAlunniMedia(); break;
        case 0: break;
      }
    }while(sceltaMenu != 0);
  }

  private void elencoAlunni() {
    classe.visualizzaObject();
  }

  private void elencoVerificheAlunno() {
    if(inserimentoCodiceAlunno())
      alunno.visualizzaVerifiche();
    else
      System.out.print("\n- Codice non trovato -\n");
  }

  private void elencoVotoMedioMateria() {
    if(inserimentoCodiceAlunno()) {
      if(inserimentoMateria())
        System.out.print("\n- Voto medio: " + alunno.getVotoMedio(nome) + " -\n");
      else
        System.out.print("\n- Materia non trovata -\n");
    }
    else
      System.out.print("\n- Codice non trovato -\n");
  }

  private void elencoVerificheAlunnoMateria() {
    if(inserimentoCodiceAlunno()) {
      if(inserimentoMateria())
        alunno.visualizzaVerifiche(nome);
      else
        System.out.print("\n- Materia non trovata -\n");
    }
    else
      System.out.print("\n- Codice non trovato -\n");
  }

  private void elencoAlunniMedia() {
    classe.visualizzaObjectConMedia();
  }

  private boolean inserimentoCodiceAlunno() {
    System.out.print("\nInserire il codice alunno: "); codice = in.nextInt();
    return classe.getObject(codice) != null;
  }

  private boolean inserimentoMateria() {
    System.out.print("\nInserire il nome della materia: "); nome = in.next();
    return alunno.getVerifica(nome) != null;
  }

  private void creazioneAlunni() {
    for (int i = 0; i < 20; i++) {
      alunno = new Alunno("Paolo" + i, "Edward" + i, i);
      classe.addObject(alunno);
    }
  }

  private void creazioneVerifiche() {
    for (int i = 0; i < 5; i++) {
      verifica = new Verifica(i + 1, (i + 1) * 3, "Materia" + i);
      alunno.addVerifica(verifica);
      verificaScritta = new VerificaScritta(i + 2, (i + 1) * 2, "Materia" + i, "Traccia" + i, (i + 1) * 4);
      alunno.addVerifica(verificaScritta);
    }
  }
}