package server;
import java.util.Random;

public class NumberGuess {
  private Random random = new Random();
  private final int range = 5;
  private int numeroEstrazione;

  public int getRandomNumber() {
    return random.nextInt(range);
  }

  public int getNumeroEstrazione() {
    return numeroEstrazione;
  }

  public void setNumeroEstrazione(int numeroEstrazione) {
    this.numeroEstrazione = numeroEstrazione;
  }
}