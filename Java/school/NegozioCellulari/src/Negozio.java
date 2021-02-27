import java.util.Scanner;
public class Negozio {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int scelta;
    Catalogo Catalogo = new Catalogo();

    do {
      System.out.print("1. Aggiungi Cellulare\n2. Rimuovi Cellulare\n3. Vendi \n4. Cerca\n5. Modifica" +
          " Quantità\n6. Visualizza numero cellulari\n7. Visualizza Catalogo\n0. Esci");
      System.out.print("\n\nScelta: "); scelta = in.nextInt();
      switch(scelta) {
        case 1:
          System.out.print("Marca: "); String marca = in.next();
          System.out.print("Processore: "); String processore = in.next();
          System.out.print("Codice: "); int codice = in.nextInt();
          System.out.print("Quantità Memoria: "); int qty_omem = in.nextInt();
          System.out.print("Quantità Disponibile: "); int qty = in.nextInt();
          System.out.print("Ore Autonomia: "); double ore_autonomia = in.nextDouble();
          System.out.print("Prezzo: "); double prezzo = in.nextDouble();

          Cellulare Cellulare = new Cellulare(marca, processore, codice, qty_omem,
              qty, ore_autonomia, prezzo);
          Catalogo.addCellulare(Cellulare);
          break;

        case 2:
          System.out.print("\nInserisci il codice del cellulare da rimuovere: ");
          int code = in.nextInt();
          Catalogo.rmvCellulare(code);
          break;

        case 3:
          System.out.print("\nInserisci il codice del cellulare da vendere: ");
          int code1 = in.nextInt();
          Catalogo.vendiCellulare(code1);
          break;

        case 4:
          System.out.println("Inserisci il codice del cellulare da cercare: ");
          int code2 = in.nextInt();
          Cellulare Cellulari = Catalogo.getCellulare(code2);
          System.out.println(Cellulari);
          break;

        case 5:
          System.out.println("Inserisci il codice del cellullare di cui modificare la quantità: ");
          int code3 = in.nextInt();
          System.out.println("Inserisci la quantità nuova: ");
          int qty1 = in.nextInt();
          Catalogo.getCellulare(code3).addQty(qty1);
          System.out.println("Modifica avvenuta con successo!");
          break;

        case 6:
          System.out.println("Cellulari disponibili: " + Catalogo.getAllQty());
          break;

        case 7:
          System.out.println(Catalogo);
          break;
      }
    }while(scelta != 0);
  }
}