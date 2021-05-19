import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseAl implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Checkbox checkbox;
        if(e.getSource() instanceof Checkbox) {
            checkbox = (Checkbox) e.getSource();
            checkbox.setState(true);
            checkbox.setBackground(Color.red);
        }
    }


    @Override
    public void mouseExited(MouseEvent e) {

    }
}