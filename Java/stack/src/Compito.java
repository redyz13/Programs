/* Scrivere le classi e l’opportuno programma Java per realizzare quanto segue:
dati in input N numeri interi, usare uno stack per conservarli. Successivamente, estraendoli
dal primo stack, distribuire i numeri in due diversi stack, uno contenente i numeri pari ed uno
contenente i numeri dispari. Alla fine visualizzare il contenuto dei due stack */

import java.util.Scanner;
import java.util.*;

public class Compito {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackDispari = new Stack<>();
        Stack<Integer> stackPari = new Stack<>();

        int[] array = new int[10];

        int n, x;

        System.out.print("Inserire la quantità di numeri da utilizzare: ");
        n = input.nextInt();


        for(int i = 0; i < n; i++) {
            System.out.print("\nInserire il " + (i + 1) + "° numero: ");
            x = input.nextInt();
            stack.push(x);
            array[i] = x;
        }

        for(int i = 0; i < n; i++) {
            if (array[i] % 2 != 0) {
                stackDispari.push(array[i]);
            }
            else
                stackPari.push(array[i]);
        }

        System.out.println("\nStack dei numeri dispari: \n" + stackDispari);
        System.out.println("Stack dei numeri pari: \n" + stackPari);
    }
}