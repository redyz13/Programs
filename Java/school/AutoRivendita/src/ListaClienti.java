public class ListaClienti {
  private Cliente[] clienti;
  private int numeroClienti;

  public ListaClienti() {
    clienti = new Cliente[100];
    numeroClienti = 0;
  }

  public void addObject(Cliente cliente) {
    clienti[numeroClienti] = cliente;
    numeroClienti ++;
  }

  public Cliente getObject(String codiceFiscale) {
    Cliente cliente = null;
    for(int i = 0; i < numeroClienti; i++)
      if (codiceFiscale.equals(clienti[i].getCodiceFiscale())) {
        cliente = clienti[i];
        break;
      }
    return cliente;
  }

  public Cliente getObjectPsw(String password) {
    Cliente cliente = null;
    for(int i = 0; i < numeroClienti; i++)
      if(password.equals(clienti[i].getPassword())) {
        cliente = clienti[i];
        break;
      }
    return cliente;
  }

  public void visualizzaObject() {
    for(int i = 0; i < numeroClienti; i ++)
      System.out.print(clienti[i]);
  }
}