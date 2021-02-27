import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class EventHandling extends JFrame {
  private JTextField textField1, textField2, textField3;
  private JPasswordField passwordField;

  public EventHandling() {
    super("Even Handling");
    setLayout(new FlowLayout());

    textField1 = new JTextField(20);
    add(textField1);

    textField2 = new JTextField("Can touch this guy", 20);
    add(textField2);

    textField3 = new JTextField("Can't touch this guy", 20);
    textField3.setEditable(false);
    add(textField3);

    passwordField = new JPasswordField("Kys", 20);
    add(passwordField);

    Handler handler = new Handler();
    textField1.addActionListener(handler);
    textField2.addActionListener(handler);
    textField3.addActionListener(handler);
    passwordField.addActionListener(handler);
  }

  private class Handler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
      String string = "";

      if(event.getSource() == textField1)
        string = String.format("Ciao1: %s", event.getActionCommand());
      else if(event.getSource() == textField2)
        string = String.format("Ciao2: %s", event.getActionCommand());
      else if(event.getSource() == textField3)
        string = String.format("Ciao3: %s", event.getActionCommand());
      else if(event.getSource() == passwordField)
        string = String.format("Password: %s", event.getActionCommand());

      JOptionPane.showMessageDialog(null, string);
    }
  }
}