import java.util.Random;
import java.sql.Date;
import java.time.LocalDate;

public class RandomGenerator {
  private Random random = new Random();
  private final int range = 10;
  private int numeroGenerato;

  public int getNumeroCasuale() {
    numeroGenerato = random.nextInt(range);

    return numeroGenerato;
  }
  
  /* - Range -
   * Carta di credito = 20
   * Pin = 4
   * CCV = 3
   */
  
  public String getNumeroCasuale(int n) {
	  	String numeroCasuale = "";
	  	
	  	for(int i = 0; i < n; i++)
	  		numeroCasuale += numeroGenerato = random.nextInt(range);

	    return numeroCasuale;
  }
  
  public Date getDataCasuale() {
	  LocalDate data = createRandomDate(2025, 2030);
	  Date dataCasuale = Date.valueOf(data);
	  
      return dataCasuale;  
  }
  
  public int createRandomIntBetween(int start, int end) {
      return start + (int) Math.round(Math.random() * (end - start));
  }
  
  public LocalDate createRandomDate(int startYear, int endYear) {
      int day = createRandomIntBetween(1, 28);
      int month = createRandomIntBetween(1, 12);
      int year = createRandomIntBetween(startYear, endYear);
      
      return LocalDate.of(year, month, day);
  }
}