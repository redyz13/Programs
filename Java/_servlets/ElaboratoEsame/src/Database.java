import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import java.sql.PreparedStatement;

public class Database {

    private String jdbcURL; 
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public Database(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public void connect() throws SQLException {
        //Controllo se è stato già aperto la connessione
        if(jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                //System.out.println("Errore metodo connect()");
            }
            //Chiedo a Java di connettersi a questo database con questo utente.
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    public void insertTitolare(Titolare titolare) throws SQLException {
        String sql = "INSERT INTO titolare (codiceTitolare, nome, cognome, username, pword, email, indirizzo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        
        statement.setInt(1, titolare.getCodiceTitolare());
        statement.setString(2, titolare.getNome());
        statement.setString(3, titolare.getCognome());
        statement.setString(4, titolare.getUsername());
        statement.setString(5, titolare.getPword());
        statement.setString(6, titolare.getEmail());
        statement.setString(7, titolare.getIndirizzo());
        
        statement.executeUpdate();

        statement.close();
    }
    
    public void insertEsercente(Esercente esercente) throws SQLException {
        String sql = "INSERT INTO esercente (codiceEsercente, nome, cognome, username, pword) VALUES (?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, esercente.getCodiceEsercente());
        statement.setString(2, esercente.getNome());
        statement.setString(3, esercente.getCognome());
        statement.setString(4, esercente.getUsername());
        statement.setString(5, esercente.getPword());
        
        statement.executeUpdate();

        statement.close();
    }
    
    public void insertCarta(Carta carta) throws SQLException {
        String sql = "INSERT INTO carta (codiceCarta, numero, pin, ccv, dataScadenza, dataCreazione, saldo, codiceTitolare) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        
        statement.setInt(1, carta.getCodiceCarta());
        statement.setString(2, carta.getNumero());
        statement.setInt(3, carta.getPin());
        statement.setInt(4, carta.getCcv());
        statement.setDate(5, carta.getDataScadenza());
        statement.setDate(6, carta.getDataCreazione());
        statement.setInt(7, carta.getSaldo());
        statement.setInt(8, carta.getCodiceTitolare());
   
        
        statement.executeUpdate();

        statement.close();
    }
    
    public void insertPagamento(Pagamento pagamento) throws SQLException {
        String sql = "INSERT INTO pagamento (codicePagamento, importo, codiceCarta, codiceEsercente) VALUES (?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        
        statement.setInt(1, pagamento.getCodicePagamento());
        statement.setInt(2, pagamento.getImporto());
        statement.setInt(3, pagamento.getCodiceCarta());
        statement.setInt(4, pagamento.getCodiceEsercente());
   
        
        statement.executeUpdate();

        statement.close();
    }
    
    public void insertMovimento(Movimenti movimento) throws SQLException {
        String sql = "INSERT INTO movimenti (codiceMovimento, importoTransazione, dataTransazione, descrizione, codiceCarta) VALUES (?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        
        statement.setInt(1, movimento.getCodiceMovimento());
        statement.setInt(2, movimento.getImportoTransazione());
        statement.setDate(3, movimento.getDataTransazione());
        statement.setString(4, movimento.getDescrizione());
        statement.setInt(5, movimento.getCodiceCarta());
   
        
        statement.executeUpdate();

        statement.close();
    }
    
    public void changeSaldo(int codiceCarta, int importo, PrintWriter out) throws SQLException {
		try {
			connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	String sql = "UPDATE carta SET saldo = saldo - \"" + importo + "\" WHERE codiceCarta = \""+ codiceCarta +"\"";

    	
    	Statement statement = null;
    	
		try {
			statement = jdbcConnection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("statement = jdbcConnection.createStatement()");
		}
		
		statement.executeUpdate(sql);
		jdbcConnection.commit();
    }
    
    public int selectSaldo(String numeroCarta, PrintWriter out) throws SQLException {
    	int saldo = -1;
    	
		try {
			connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	String sql = "SELECT saldo FROM carta WHERE numero = \""+ numeroCarta +"\"";

    	Statement statement = null;
    	
		try {
			statement = jdbcConnection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("statement = jdbcConnection.createStatement()");
		}
		
	  	ResultSet resultSet = null;
    	
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			out.println("statement.executeQuery(sql)");
		}
		
		while(resultSet.next()) {
			saldo = resultSet.getInt("saldo");
		}
		
		resultSet.close();
		
		return saldo;
    }
    
    public int selectNumeroCarta(int pin, PrintWriter out) throws SQLException {
    	int codiceCarta = -1;
    	
		try {
			connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	String sql = "SELECT codiceCarta FROM carta WHERE pin = \""+ pin +"\"";

    	Statement statement = null;
    	
		try {
			statement = jdbcConnection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("statement = jdbcConnection.createStatement()");
		}
		
	  	ResultSet resultSet = null;
    	
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			out.println("statement.executeQuery(sql)");
		}
		
		while(resultSet.next()) {
			codiceCarta = resultSet.getInt("codiceCarta");
		}
		
		resultSet.close();
		
		return codiceCarta;
    }
    
    public int selectCodiceEsercente(String username, PrintWriter out) throws SQLException {
    	int codiceEsercente = -1;
    	
		try {
			connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	String sql = "SELECT codiceEsercente FROM Esercente WHERE username = \""+ username +"\"";

    	Statement statement = null;
    	
		try {
			statement = jdbcConnection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("statement = jdbcConnection.createStatement()");
		}
		
	  	ResultSet resultSet = null;
    	
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			out.println("statement.executeQuery(sql)");
		}
		
		while(resultSet.next()) {
			codiceEsercente = resultSet.getInt("codiceEsercente");
		}
		
		resultSet.close();
		
		return codiceEsercente;
    }
    
    public int selectTitolare(String username, String pword, PrintWriter out) throws SQLException {
    	String dbpsw;
    	
		try {
			connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	String sql = "SELECT pword FROM titolare WHERE username = \""+ username +"\"";

    	Statement statement = null;
    	
		try {
			statement = jdbcConnection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("statement = jdbcConnection.createStatement()");
		}
		
    	ResultSet resultSet = null;
    	
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			out.println("statement.executeQuery(sql)");
		}
		
		if(resultSet.next()) {
			dbpsw = resultSet.getString("pword");
			if(dbpsw.equals(pword)) {
				return 0;
			} else {
				return -2;
			}
		} else {
			return -1;
		}
    }
		
	public int selectEsercente(String username, String pword, PrintWriter out) throws SQLException {
	    String dbpsw;
	    	
		try {
			connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    String sql = "SELECT pword FROM esercente WHERE username = \""+ username +"\"";

	    Statement statement = null;
	    
		try {
			statement = jdbcConnection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("statement = jdbcConnection.createStatement()");
		
		}
		
	    ResultSet resultSet = null;
	    
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			out.println("statement.executeQuery(sql)");
		}
			
		if(resultSet.next()) {
			dbpsw = resultSet.getString("pword");
			if(dbpsw.equals(pword)) {
				return 0;
			} else {
				return -2;
			}
			
			} else {
				return -1;
			}
    }

    public String getJdbcURL() {
        return this.jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    public String getJdbcUsername() {
        return this.jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcPassword() {
        return this.jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public Connection getJdbcConnection() {
        return this.jdbcConnection;
    }

    public void setJdbcConnection(Connection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    @Override
    public String toString() {
        return "{" +
            " jdbcURL='" + getJdbcURL() + "'" +
            ", jdbcUsername='" + getJdbcUsername() + "'" +
            ", jdbcPassword='" + getJdbcPassword() + "'" +
            ", jdbcConnection='" + getJdbcConnection() + "'" +
            "}";
    }
}