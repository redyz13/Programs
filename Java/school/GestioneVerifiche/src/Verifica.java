public class Verifica {
  protected double voto;
  protected int data;
  protected String materia;

  public Verifica(double voto, int data, String materia) {
    this.voto = voto;
    this.data = data;
    this.materia = materia;
  }

  public double getVoto() {
    return voto;
  }

  public int getData() {
    return data;
  }

  public String getMateria() {
    return materia;
  }

  public void setVoto(double voto) {
    this.voto = voto;
  }

  public void setData(int data) {
    this.data = data;
  }

  public void setMateria(String materia) {
    this.materia = materia;
  }

  @Override
  public String toString() {
    return "\n- Verifica n." + 0 + " -\n" +
        "\tVoto: " + getVoto() + "\n" +
        "\tData: " + getData() + "\n" +
        "\tMateria: " + getMateria() + "\n";
  }
}