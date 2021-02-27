import javax.swing.*;
import java.awt.*;
public class Main {
  public static void main(String[] args) {
    Frame f = new Frame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension dim = tk.getScreenSize();

    f.setSize(dim.width / 2, dim.height / 2);
    f.setLocation(dim.width / 4, dim.height / 4);
    f.getContentPane().setBackground(Color.darkGray);
    f.gui();
    f.setVisible(true);
  }
}