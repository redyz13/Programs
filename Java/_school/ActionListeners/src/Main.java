import javax.swing.*;
import java.awt.*;
public class Main {
  public static void main(String[] args) {
    EventHandling eventHandling = new EventHandling();
    eventHandling.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension dim = tk.getScreenSize();

    eventHandling.setSize(dim.width / 2, dim.height / 2);
    eventHandling.setLocation(dim.width / 4, dim.height / 4);
    eventHandling.getContentPane().setBackground(Color.darkGray);
    eventHandling.setVisible(true);
  }
}