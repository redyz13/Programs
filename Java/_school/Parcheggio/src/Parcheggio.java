import java.util.Scanner;
public class Parcheggio {
  Scanner in = new Scanner(System.in);
  private Posto[] posti;
  private final int idxPrimoPostoAuto = 0;
  private final int idxPrimoPostoMoto = 150;
  private int numeroPostiAuto, numeroPostiMoto;

  public Parcheggio() {
    posti = new Posto[300];
    numeroPostiAuto = 0;
    numeroPostiMoto = 0;
  }

  public void listaPostiAutoLiberi() {
    String s;

    for(int i = idxPrimoPostoAuto; i < idxPrimoPostoMoto; i ++)
      if(!posti[i].getOccupato()) {
        s = posti[i].getNumeroPostoString();
        System.out.println(s);
      }
  }

  public void listaPostiMotoLiberi() {
    String s;

    for(int i = idxPrimoPostoMoto; i < 300; i ++)
      if(!posti[i].getOccupato()) {
        s = posti[i].getNumeroPostoString();
        System.out.println(s);
      }
  }

  public boolean listaPostiAutoOccupati() {
    String s = null;

    for(int i = idxPrimoPostoAuto; i < idxPrimoPostoMoto; i ++)
      if(posti[i].getOccupato()) {
        s = posti[i].getNumeroPostoString();
        System.out.println(s);
      }

    return s != null;
  }

  public boolean listaPostiMotoOccupati() {
    String s = null;

    for(int i = idxPrimoPostoMoto; i < 300; i ++)
      if(posti[i].getOccupato()) {
        s = posti[i].getNumeroPostoString();
        System.out.println(s);
      }

    return s != null;
  }

  public void addPostoAuto(Posto posto) {
    posti[numeroPostiAuto] = posto;
    numeroPostiAuto ++;
  }

  public void addPostoMoto(Posto posto) {
    posti[idxPrimoPostoMoto + numeroPostiMoto] = posto;
    numeroPostiMoto ++;
  }

  public Posto getPosto(int numero) {
    boolean trovato = false;
    int c = 0;
    while(c < 300 && !trovato) {
      if(posti[c].getNumero() == numero)
        trovato = true;
      else
        c ++;
    }

    if(trovato)
      return posti[c];
    else
      return null;
  }
    
    public boolean parcheggiaVeicolo() {
        int numPosto;
        Posto posto;
        
        System.out.print("\nIn quale posto vuoi parcheggiare?: ");
        numPosto = in.nextInt();
        
        posto = getPosto(numPosto);
        
        if(posto != null && !posto.getOccupato()) {
          posto.setOccupato(true);
          return true;
        }

        return false;
    }
}