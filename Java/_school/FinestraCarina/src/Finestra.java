import javax.swing.*;
import java.awt.*;

public class Finestra extends JFrame {
    public Finestra() {
        super();
        setSize(500, 500);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JRadioButton radioButton1 = new JRadioButton("Opzione 1", true);
        JRadioButton radioButton2 = new JRadioButton("Opzione 2");
        JRadioButton radioButton3 = new JRadioButton("Opzione 3");
        JRadioButton radioButton4 = new JRadioButton("Opzione 4");

        radioButton1.setBounds(10, 10, 100, 20);
        radioButton2.setBounds(10, 30, 100, 20);
        radioButton3.setBounds(10, 50, 100, 20);
        radioButton4.setBounds(10, 70, 100, 20);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        buttonGroup.add(radioButton4);

        add(radioButton1); add(radioButton2);
        add(radioButton3); add(radioButton4);

        DefaultListModel dm = new DefaultListModel();
        RadioButtonAl radioButtonAl = new RadioButtonAl(dm);

        radioButton1.addActionListener(radioButtonAl);
        radioButton2.addActionListener(radioButtonAl);
        radioButton3.addActionListener(radioButtonAl);
        radioButton4.addActionListener(radioButtonAl);

        JList list = new JList();
        list.setLocation(150, 10);
        list.setSize(100, 300);
        list.setBackground(Color.cyan);

        list.setModel(dm);
        dm.addElement("");

        JCheckBox checkBox1 = new JCheckBox();
        checkBox1.setLocation(300, 10);
        checkBox1.setSize(100, 300);
        checkBox1.setText("Text");

        MouseAl mouseAl = new MouseAl();
        checkBox1.addMouseListener(mouseAl);

        add(list);
        add(checkBox1);
        setLayout(null);
    }

    public static void main(String[] args) {
        Finestra f = new Finestra();
        f.setVisible(true);
    }
}