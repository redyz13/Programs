import java.util.Scanner;
public class Finestra {
  static Frame fr = new Frame();

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Scegliere il colore della finestra (y, n)?: ");
    if(in.next().equals("y"))
      colorInput();
    else
      fr.setVisible(true);
  }

  private static void colorInput() {
    Scanner in = new Scanner(System.in).useDelimiter("[,\\s+]");
    int[] a = new int[3];
    int x = 0;
    System.out.print("Sceglire il colore RGB della finestra (1,2,3): ");
    while(x < 3) {
      if(in.hasNextInt()) {
        a[x] = in.nextInt();
        x ++;
      }
    }
    fr.setColor(a);
    fr.setVisible(true);
  }
}