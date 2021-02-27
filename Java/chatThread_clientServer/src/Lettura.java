import java.io.IOException;

public class Lettura implements Runnable {

  private JServer server;

  public Lettura(JServer server) {
    this.server = server;
  }

  @Override
  public void run() {
    //while(server.getSocket().isClosed()) {
    while(true)	{
      try {
        String text = server.getBr().readLine();
        System.out.println(text);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
