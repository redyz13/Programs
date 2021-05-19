import java.util.ArrayList;
import java.util.List;

public class ListaProdotti {

  private List<Prodotto> lista = new ArrayList();
  private int qty=0;

  public ListaProdotti() {
    caricaProdotti();
  }

  public Prodotto getProdotto(int codice) {
    Prodotto x = null;
    for(int i=0; i<lista.size(); i++) {
      if(codice == lista.get(i).getCodice()) {
        x = lista.get(i);
      }
    }
    return x;
  }

  public void AddQty(int codice, int qty) {
    int x = lista.get(codice).getNumero();
    lista.get(codice).setNumero(x + qty);
  }

  public void getAllString() {
    for(int i=0; i<lista.size(); i++) {
        System.out.print(lista.get(i).toString());
    }
  }

  private void caricaProdotti() {
    for(int i=0; i<5; i++) {
      lista.add(new Prodotto("" + i, i, i, i));
      qty++;
    }
  }

  public int getQty() {
    return qty;
  }
}