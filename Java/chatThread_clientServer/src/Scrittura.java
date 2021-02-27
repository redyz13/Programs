import java.util.Scanner;

public class Scrittura implements Runnable {

  private JServer server;

  public Scrittura(JServer server) {
    this.server = server;
  }

  @Override
  public void run() {
    //while(server.getSocket().isClosed()) {
    while(true)	{
      Scanner scanner = new Scanner(System.in);
      String text = scanner.nextLine();
      server.getPw().println(text);
    }

    //System.out.println("[SERVER] Sessione terminata! ");

  }

}
