public class Automobile {
  private boolean stato = false;
  private double vel = 0;

  public Automobile() {
    this.stato = stato;
    this.vel = vel;
  }

  public boolean getStato() {
    return stato;
  }

  public double getVel() {
    return vel;
  }

  public int addVel(double vel) {
    if (vel <= 0)
      return -1;
    else {
      this.vel = this.vel + vel;
      return 0;
    }
  }

  public int decVel(double vel) {
    int flag = -1;

    if (vel >= 0 && this.vel > vel) {
      this.vel -= vel;
      flag = 0;
    }

    return flag;
  }

  public boolean accendiAuto() {
    stato = true;
    return true;
  }

  public boolean spegniAuto() {
    vel = 0;
    stato = false;
    return false;
  }
}