import java.util.Scanner;
public class Simulatore {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Automobile auto1, auto2;
    auto1 = new Automobile(); auto2 = new Automobile();
    int scelta, selezione1;
    double vel = 0;
    boolean stato = false, exit = false, flag = true;

    do {
      System.out.println("\nSelezionare un auto\n1. Auto 1\n2. Auto 2\n0. Esci");
      System.out.print("\nSelezione: "); scelta = in.nextInt();

      switch(scelta) {
        case 1:
          if(!stato && flag) {
            System.out.print("\nAccendere l'automobile? (1. Si - 2. No)");
            System.out.print("\nSelezione: "); selezione1 = in.nextInt();

            if(selezione1 == 1) {
              flag = false;
              stato = auto1.accendiAuto();
              System.out.print("\n- Automobile Accesa -\n");
            }
          }
          else
            exit = false;

          while(stato && !exit) {
            System.out.println("\n1. Accelera\n2. Decellera\n3. Visualizza km/h attuali\n" +
                "4. Spegni Auto\n0. Esci dalla selezione");
            System.out.print("\nSelezione: "); selezione1 = in.nextInt();

            switch(selezione1) {
              case 1:
                System.out.println("\nSeleziona i km/h da aggiungere alla velocità attuale (" +
                    auto1.getVel() + "km/h)");
                System.out.print("\nAumenta di: "); vel = in.nextDouble();

                if(auto1.addVel(vel) == 0)
                  System.out.print("\n- Velocità aumentata -\n");
                else
                  System.out.print("\n- Valore Errato -\n");
                break;

              case 2:
                System.out.println("\nSeleziona i km/h da rimuovere alla velocità attuale (" +
                    auto1.getVel() + "km/h)");
                System.out.print("\nDiminuisci di: "); vel = in.nextDouble();

                if(auto1.decVel(vel) == 0)
                  System.out.print("\n- Velocità diminuita -\n");
                else
                  System.out.print("\n- Valore Errato -\n");
                break;

              case 3:
                System.out.print("\n- Velocità attuale = " + auto1.getVel() + "km/h -\n");
                break;

              case 4:
                stato = auto1.spegniAuto();
                System.out.print("\n- Automobile Spenta -\n");
                flag = true;
                break;

              case 0:
                exit = true;
                break;
            }
          }

          break;

        case 2:

          break;
      }

    }while(scelta != 0);
  }
}