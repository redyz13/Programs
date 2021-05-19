import java.util.Scanner;
public class MainMethods {
  Scanner in = new Scanner(System.in);
  Parcheggio parcheggio = new Parcheggio();
  private Posto posto;
  private PostoAuto postoAuto;
  private PostoMoto postoMoto;

  public void menu() {
    creaPosti();
    int sceltaMenu;
    do {
      System.out.println("\n1. Parcheggia Veicolo\n2. Paga importo" +
          "\n3. Elenca posti auto liberi\n4. Elenca posti moto liberi\n5. Elenca posti auto occupati" +
          "\n6. Elenca posti moto occupati\n0. Esci");
      System.out.print("\nSelezione: ");
      sceltaMenu = in.nextInt();
      switch(sceltaMenu) {
        case 1: parcheggiaVeicolo(); break;
        case 2: pagaImporto(); break;
        case 3: elencaPostiAutoLiberi() ; break;
        case 4: elencaPostiMotoLiberi(); break;
        case 5: elencaPostiAutoOccupati(); break;
        case 6: elencaPostiMotoOccupati(); break;
        case 0: break;
      }
    }while(sceltaMenu != 0);
  }

  public void pagaImporto() {
    System.out.print("\nInserire il numero del posto precedentemente occupato: "); int numero = in.nextInt();
    posto = parcheggio.getPosto(numero);
    if(posto != null && posto.getOccupato()) {
      System.out.println("\nImporto da pagare: €" + posto.getTariffa());
      System.out.print("Pagamento: "); double pagamento = in.nextDouble();
      if(pagamento >= posto.getTariffa()) {
        System.out.println("\nResto: €" + (pagamento - posto.getTariffa()));
        posto.setOccupato(false);
      }
      else
        System.out.print("\n- Pagamento insufficiente -\n");
    }
    else
      System.out.print("\n- Posto non trovato -\n");
  }

  public void parcheggiaVeicolo() {
    if(parcheggio.parcheggiaVeicolo())
      System.out.print("\n- Veicolo Parcheggiato -\n");
    else
      System.out.print("\n- Posto Occupato -\n");
  }

  public void elencaPostiAutoLiberi() {
    parcheggio.listaPostiAutoLiberi();
  }

  public void elencaPostiAutoOccupati() {
    if(!parcheggio.listaPostiAutoOccupati())
      System.out.print("\n- Nessun posto occupato -\n");
  }

  public void elencaPostiMotoLiberi() {
    parcheggio.listaPostiMotoLiberi();
  }

  public void elencaPostiMotoOccupati() {
    if(!parcheggio.listaPostiMotoOccupati())
      System.out.print("\n- Nessun posto occupato -\n");
  }


  public void creaPosti() {
    boolean x = true;
    for(int i = 0; i < 150; i ++) {
      x ^= true;
      postoAuto = new PostoAuto(i, (i + 1) * 5);
      parcheggio.addPostoAuto(postoAuto);
      postoMoto = new PostoMoto(i + 150, (i + 1) * 3);
      parcheggio.addPostoMoto(postoMoto);
    }
  }
}