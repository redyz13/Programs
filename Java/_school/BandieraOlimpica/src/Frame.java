import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame {
  public Frame() {
    super();
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension dim = tk.getScreenSize();
    setTitle("Bandiera Olimpica");
    setSize(dim.width / 2, dim.height / 2);
    setLocation(dim.width / 4, dim.height / 4);
    getContentPane().setBackground(Color.darkGray);
    //setExtendedState(JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
  }
}