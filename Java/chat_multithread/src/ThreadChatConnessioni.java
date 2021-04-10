import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadChatConnessioni implements Runnable {
    private ThreadGestioneServizioChat gestoreChat;
    private Socket client = null;
    private BufferedReader input = null;
    private PrintWriter output = null;
    Thread me;

    public ThreadChatConnessioni(ThreadGestioneServizioChat gestoreChat, Socket client) {
        this.gestoreChat = gestoreChat;
        this.client = client;
        try {
            this.input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            this.output = new PrintWriter(this.client.getOutputStream(), true);
        } catch (Exception e) {
            output.println("Errore nella lettura");
        }

        me = new Thread(this);
        me.start();
    }



    @Override
    public void run() {
        while(true) {
            try {
                String m = null;

                // Rimango in attesa dei messaggi inviati al client
                while((m = input.readLine()) == null) { }

                // Inserimento del messaggio nella lista dei messaggi

            } catch (Exception e) {
                output.println("Errore");
            }
        }
    }

    public void spedisciMessaggioChat(String messaggio) {
        try {
            output.println(messaggio);
        } catch (Exception e) {
            output.println("Errore nella spedizione del singolo messaggio");
        }
    }
}