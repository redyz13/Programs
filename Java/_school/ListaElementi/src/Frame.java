import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Frame extends JFrame {
  private JPanel p;
  private JButton b1, b2, b3, b4;
  private JList list;
  private JTextField textField;
  private DefaultListModel dm = new DefaultListModel();

  public Frame() {
    super("Lista Elementi");
    setLayout(new FlowLayout());
  }

  public void gui() {
    JPanel panel = new JPanel();

    list = new JList();
    list.setPreferredSize(new Dimension(200, 270));

    panel.add(list);
    add(panel);

    textField = new JTextField(20);
    add(textField);

    p = new JPanel();
    p.setBackground(Color.white);

    b1 = new JButton("Salva");
    b1.addActionListener(this::addBtnActionPerformed);

    b2 = new JButton("Elimina Tutto");
    b2.addActionListener(this::clearBtnActionPerformed);

    b3 = new JButton("Elimina Elemento");
    b3.addActionListener(this::deleteBtnActionPerformed);

    b4 = new JButton("Aggiorna Elemento");
    b4.addActionListener(this::updateBtnActionPerforemd);

    p.add(b1);
    p.add(b2);
    p.add(b3);
    p.add(b4);

    add(p);

    //Rimuove un elemento a cui si fa doppio click
    list.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JList list = (JList)e.getSource();
        if(e.getClickCount() == 2) {
          int index = list.getSelectedIndex();
          dm.removeElementAt(index);

          //Clear
          textField.setText("");
        }

      }
    });
  }

  //Aggiunge alla lista il testo immesso nel textField
  private void addBtnActionPerformed(java.awt.event.ActionEvent e) {
    addElement(textField.getText());

    //Clear
    textField.setText("");
  }

  private void addElement(String element) {
    list.setModel(dm);
    dm.addElement(element);
  }

  //Rimuove dalla lista tutti gli elementi
  private void clearBtnActionPerformed(java.awt.event.ActionEvent e) {
    dm.clear();
    list.setModel(dm);
  }

  //Aggiorna l'elemento selezionato nella lista
  private void updateBtnActionPerforemd(java.awt.event.ActionEvent e) {
    int index = list.getSelectedIndex();
    dm.setElementAt(textField.getText(), index);

    //Clear
    textField.setText("");
  }

  //Rimuove dalla lista l'elemento selezionato
  private void deleteBtnActionPerformed(java.awt.event.ActionEvent e) {
    int index = list.getSelectedIndex();
    dm.removeElementAt(index);

    //Clear
    textField.setText("");
  }
}