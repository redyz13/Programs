import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadGestioneServizioChat implements Runnable {
    private int nMaxConnessioni;
    private List lista;
    private ThreadChatConnessioni[] listaConnessioni;
    Thread me;
    private ServerSocket serverChat;

    public ThreadGestioneServizioChat(int nMaxConnessioni, List lista) {
        this.nMaxConnessioni = nMaxConnessioni;
        this.lista = lista;
        this.listaConnessioni = new ThreadChatConnessioni[this.nMaxConnessioni];
        me = new Thread(this);
        me.start();
    }

    @Override
    public void run() {
        boolean continua = true;

        // Instanzio la connessione del server per la chat
        try {
            serverChat = new ServerSocket(7000);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossibile instanziare il server");
            continua = false;
        }

        if(continua) {
            try {
                for(int i = 0; i < nMaxConnessioni; i++) {
                    Socket tempo = null;
                    tempo = serverChat.accept();
                    listaConnessioni[i] = new ThreadChatConnessioni(this, tempo);
                }

                serverChat.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Impossibile instanziare server chat");
            }
        }
    } // Fine metodo run

    public void spedisciMessaggio(String m) {
        // Scrivo il messaggio nella mia lista
        lista.add(m);
        lista.select(lista.getItemCount() - 1);

        // Mando il messaggio agli altri
        for(int i = 0; i < this.nMaxConnessioni; i++)
            if(listaConnessioni[i] != null)
                listaConnessioni[i].spedisciMessaggioChat(m);
    }

}