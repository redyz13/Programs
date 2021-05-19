import java.util.Scanner;
public class Main {
    private Prodotto prodotto;
    private ProdottoAlimentare prodottoAlimentare;
    private Detersivo detersivo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MainMethods mm = new MainMethods();

        mm.menu();
    }
}