import java.util.Scanner;
public class MainMethods {
  Scanner in = new Scanner(System.in);
  ListaVeicoli listaVeicoli = new ListaVeicoli();
  private Veicolo veicolo;
  private Vettura vettura;
  private Motociclo motociclo;
  private String targa;

  public void menu() {
    creazioneVeicoli();
    int sceltaMenu;
    do {
      System.out.println("\n1. Verifica Veicolo\n2. Stampa Lista Veicoli" +
          "\n3. Stampa Lista Veicoli Guasti\n4. Stampa Lista Veicoli Riparati\n0. Esci");
      System.out.print("\nSelezione: ");
      sceltaMenu = in.nextInt();
      switch(sceltaMenu) {
        case 1: verificaVeicolo(); break;
        case 2: stampaListaVeicoli(); break;
        case 3: stampalistaGuasti() ; break;
        case 4: stampalistaRiparati(); break;
        case 0: break;
      }
    }while(sceltaMenu != 0);
  }

  private void verificaVeicolo() {
    System.out.print("\nInserire la targa del veicolo: "); targa = in.next();
    if(listaVeicoli.getObject(targa).getStato())
      System.out.print("\n- Veicolo Riparato -\n");
    else
      System.out.print("\n- Veicolo Guasto -\n");
  }

  private void stampaListaVeicoli() {
    listaVeicoli.visualizzaObject();
  }

  private void stampalistaGuasti() {
    listaVeicoli.visualizzaGuasti();
  }

  private void stampalistaRiparati() {
    listaVeicoli.visualizzaRiparati();
  }

  private void creazioneVeicoli() {
    boolean x = true;
    for(int i = 0; i < 5; i ++) {
      x ^= true;
      veicolo = new Veicolo("MarcaVeicolo" + i, "A" + i, "ModelloVeicolo" + i, x);
      listaVeicoli.addObject(veicolo);
      vettura = new Vettura("MarcaVettura" + i, "B" + i, "ModelloVettura" + i, x, "Tipologia" + i);
      listaVeicoli.addObject(vettura);
      motociclo = new Motociclo("MarcaMotociclo" + i, "C" + i, "ModelloMotociclo" + i, x, (i + 1) * 300);
      listaVeicoli.addObject(motociclo);
    }
  }
}