import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        super();
        Toolkit tk = Toolkit.getDefaultToolkit(); // Toolkit per interrogare la scheda grafica per sapere i pixel
        Dimension dim = tk.getScreenSize();
        this.setTitle("Frame"); // Titolo Finestra
        this.setSize(dim.width / 2, dim.height / 2); // Grandezza Finestra
        this.setLocation(dim.width / 4, dim.height / 4); // Posizione Finestra
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Massimizza Finestra
        //this.setVisible(true); // Visibilità Finestra
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE ); // Chiusura Processo
    }

    public void setColor(int[] a) {
        Color c = new Color(a[0], a[1], a[2]); // Creazione Colore
        this.getContentPane().setBackground(c); // Colore Sfondo
        // deeppink 	#FF1493 	rgb(255,20,147)
    }
}