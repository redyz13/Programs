import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finestra extends JFrame {
  private ListaAuto listaAuto = new ListaAuto();
  private ListaClienti listaClienti = new ListaClienti();
  private JFrame f;
  private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9 ,t10, t11,
      t12, t13, t14, t15, t16, t17, t18, t19, t20;
  private JButton b1, b2;
  private JList jlistaAuto;
  private DefaultListModel dm = new DefaultListModel();

  public Finestra() {
    super();
    f = new JFrame("AutoRivendita");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension dim = tk.getScreenSize();

    f.setSize(dim.width / 2, dim.height / 2);
    f.setLocation(dim.width / 4, dim.height / 4);
    f.getContentPane().setBackground(Color.darkGray);

    t1 = new JTextField();
    t2 = new JTextField();
    t3 = new JTextField();
    t4 = new JTextField();
    t5 = new JTextField();
    t6 = new JTextField();
    t7 = new JTextField();
    t8 = new JTextField();
    t9 = new JTextField();
    t10 = new JTextField();
    t11 = new JTextField();
    t12 = new JTextField("Marca");
    t13 = new JTextField("Modello");
    t14 = new JTextField("Stato Auto");
    t15 = new JTextField("Anno Immatricolazione");
    t16 = new JTextField("Numero Proprietari");
    t17 = new JTextField("Km Percorsi");
    t18 = new JTextField("Prezzo");
    t19 = new JTextField("Codice");
    t20 = new JTextField("Password");

    t1.setBounds(10,10, 100,20);

    t12.setBounds(170, 10, 100, 20);
    t12.setEditable(false);

    t2.setBounds(10,50,100,20);

    t13.setBounds(170, 50, 100, 20);
    t13.setEditable(false);

    t3.setBounds(10,90,140,30);

    t14.setBounds(170, 90, 100, 30);
    t14.setEditable(false);

    t4.setBounds(10,145,100,20);

    t15.setBounds(170, 145, 150, 20);
    t15.setEditable(false);

    t5.setBounds(10,190,100,20);

    t16.setBounds(170, 190, 100, 20);
    t16.setEditable(false);

    t6.setBounds(10,240,100,20);

    t17.setBounds(170,240,100,20);
    t17.setEditable(false);

    t7.setBounds(10,290,100,20);

    t18.setBounds(170,290,100,20);
    t18.setEditable(false);

    t8.setBounds(10,340,100,20);

    t19.setBounds(170, 340, 100, 20);
    t19.setEditable(false);


    t9.setBounds(900,10,100,20);

    t20.setBounds(1010,10,100,20);
    t20.setEditable(false);

    t10.setBounds(900,50,100,20);

    t20.setEditable(false);

    b1 = new JButton("Registra");
    b2 = new JButton("Acquista");

    b1.setBounds(85,400,100,20);
    b1.addActionListener(new Aggiungi());

    b2.setBounds(1010,130, 100,20);
    b2.addActionListener(new Acquista());

    jlistaAuto = new JList();
    jlistaAuto.setBounds(600,10,200,200);

    f.add(t1);
    f.add(t2);
    f.add(t3);
    f.add(t4);
    f.add(t5);
    f.add(t6);
    f.add(t7);
    f.add(t8);
    f.add(t9);
    f.add(t10);
    f.add(t11);
    f.add(t12);
    f.add(t13);
    f.add(t14);
    f.add(t15);
    f.add(t16);
    f.add(t17);
    f.add(t18);
    f.add(t19);
    f.add(t20);

    f.add(b1);
    f.add(b2);
    f.add(jlistaAuto);

    f.setVisible(true);
  }

  public class Aggiungi implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      String tx1 = t1.getText();
      String tx2 = t2.getText();
      String tx3 = t3.getText();
      String tx4 = t4.getText();
      String tx5 = t5.getText();
      String tx6 = t6.getText();
      String tx7 = t7.getText();

      t1.setText("");
      t2.setText("");
      t3.setText("");
      t4.setText("");
      t5.setText("");
      t6.setText("");
      t7.setText("");
      t8.setText("");

     //Auto auto = new Auto();
    }
  }

  public class Acquista implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }
  }
}