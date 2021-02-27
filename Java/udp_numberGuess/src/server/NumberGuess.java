package server;
import java.util.Random;

public class NumberGuess {
  private Random random = new Random();
  private final int range = 5;
  private int numeroEstrazione;

  public int getRandomNumber() {
    numeroEstrazione = random.nextInt(range);

    return numeroEstrazione;
  }

  public int getNumeroEstrazione() {
    return numeroEstrazione;
  }
}