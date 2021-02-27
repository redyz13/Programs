public class ListaProdotti {
    private Prodotto[] prodotti;
    private int numeroProdotti;

    public ListaProdotti() {
        prodotti = new Prodotto[100];
    }

    public void addObject(Prodotto prodotto) {
        prodotti[numeroProdotti] = prodotto;
        numeroProdotti ++;
    }

    public Prodotto getObject(int codice) {
        Prodotto prodotto = null;
        for (int i = 0; i < numeroProdotti; i++)
            if (codice == (prodotti[i].getCodice())) {
                prodotto = prodotti[i];
                break;
            }
        return prodotto;
    }

    public void visualizzaObject() {
        for(int i = 0; i < numeroProdotti; i ++)
            System.out.print(prodotti[i]);
    }

    public boolean removeObject(int codice) {
        Prodotto prodotto = getObject(codice);
        if(prodotto != null) {
            int i = getObjectIndex(codice);
            for(int j = i + 1; j < numeroProdotti; j ++)
                prodotti[j - 1] = prodotti[j];
            numeroProdotti --;
            return true;
        }
        return false;
    }

    public boolean verificaCodice(int codice) {
        for(int i = 0; i < numeroProdotti; i ++)
            if(codice == prodotti[i].getCodice())
                return false;
        return true;
    }

    private int getObjectIndex(int codice) {
        for(int i = 0; i < numeroProdotti; i ++)
            if(prodotti[i].getCodice() == codice)
                return i;
        return -1;
    }

    public void visualizzaAlimentari() {
        for(int i = 0; i < numeroProdotti; i ++) {
            if(prodotti[i] instanceof ProdottoAlimentare)
                System.out.print(prodotti[i]);
        }
    }

    public void visualizzaDetersivi() {
        for(int i = 0; i < numeroProdotti; i ++) {
            if(prodotti[i] instanceof Detersivo)
                System.out.print(prodotti[i]);
        }
    }
}