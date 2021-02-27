import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonAl implements ActionListener {
    private DefaultListModel defaultListModel;

    public RadioButtonAl(DefaultListModel defaultListModel) {
        super();
        this.defaultListModel = defaultListModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton r = (JRadioButton) e.getSource();
        defaultListModel.addElement(r.getText());
    }
}