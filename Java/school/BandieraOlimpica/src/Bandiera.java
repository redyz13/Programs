import java.awt.*;
public class Bandiera extends Canvas {
  @Override
  public void paint(Graphics g) {
    Color blue = new Color(57, 157, 206);
    Color red = new Color(237, 51, 78);
    Color yellow = new Color(251, 177, 50);
    Color green = new Color(28, 139, 60);

    g.setColor(blue);
    g.drawOval(10, 10, 200, 200);
    g.setColor(Color.black);
    g.drawOval(230, 10, 200, 200);
    g.setColor(red);
    g.drawOval(450, 10, 200, 200);
    g.setColor(yellow);
    g.drawOval(120, 110, 200, 200);
    g.setColor(green);
    g.drawOval(340, 110, 200, 200);

    g.setFont(new Font("Arial", Font.BOLD, 16));
    g.setColor(Color.lightGray);
    g.drawString("Antonio D'Auria", 270, 330);
  }
}