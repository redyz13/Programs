public class Catalogo {
  private Libro[] libri;
  private int numeroLibri;

  public Catalogo() {
    libri = new Libro[100];
    numeroLibri = 0;
  }

  public void addLibro(Libro libro) {
    libri[numeroLibri] = libro;
    numeroLibri ++;
  }

  public Libro getLibro(String isbn) {
    Libro libro = null;
    for(int i = 0; i < numeroLibri; i++)
      if(isbn.equals(libri[i].getIsbn())) {
        libro = libri[i];
        break;
      }
    return libro;
  }

  public boolean removeLibro(String isbn) {
    Libro libro = getLibro(isbn);
    if(libro != null) {
      int i = getObjectIndex(isbn);
      for(int j = i + 1; j < numeroLibri; j ++)
        libri[j - 1] = libri[j];
      numeroLibri --;
      return true;
    }
    return false;
  }

  private int getObjectIndex(String isbn) {
    for(int i = 0; i < numeroLibri; i ++)
      if(libri[i].getIsbn().equals(isbn))
        return i;
    return -1;
  }

  public void visualizzaLibri() {
    for(int i = 0; i < numeroLibri; i ++)
      System.out.print(libri[i]);
  }

  public Libro cercaLibroTitolo(String s) {
    Libro libro = null;
    for(int i = 0; i < numeroLibri; i++)
      if(s.equals(libri[i].getTitolo()))
        libro = libri[i];
    return libro;
  }

  public String cercaLibroAutore(String s) {
    Libro libro = null;
    String r = "";
    for(int i = 0; i < numeroLibri; i ++)
      if(s.equals(libri[i].getAutore()))
        r += libri[i].toString();
    return r;
  }

  public boolean verIsbns(String isbn) {
    for(int i = 0; i < numeroLibri; i ++)
      if(isbn.equals(libri[i].getIsbn()))
        return true;
    return false;
  }
}