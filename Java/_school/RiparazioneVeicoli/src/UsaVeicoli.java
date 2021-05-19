import java.util.Scanner;
public class UsaVeicoli {
  private Veicolo veicolo;
  private Vettura vettura;
  private Motociclo motociclo;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    MainMethods mm = new MainMethods();

    mm.menu();
  }
}