

import java.io.IOException;

public class MainProgram {

  public static void main(String[] args) {
    JServer server = new JServer();
    try {
      server.connect();
      server.communicazione();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
