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

        //Controllo se � stato gi� aperto la connessione
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

    public void insertUtente(Utente utente) throws SQLException {
        //Creo la sql di default
        String sql = "INSERT INTO utenti (username, password, nome, cognome) VALUES (?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, utente.getUsername()); //Primo ?
        statement.setString(2, utente.getPassword()); //Secondo ?
        statement.setString(3, utente.getNome()); //Terzo ?
        statement.setString(4, utente.getCognome());
        
        //Eseguo la querry una volta inserito gli attributi
        statement.executeUpdate();

        statement.close();
        
    }
    
    public Utente selectUtente(String username, String password) throws SQLException {
    	Utente utente = null;
		connect();
    	String sql = "SELECT * FROM utenti HAVING username = \" "+ username + " \" and password = \" " + password + "\"";

    	Statement statement = jdbcConnection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while(resultSet.next()) {
    		utente = new Utente(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("nome"), resultSet.getString("cognome"));
    	}
    	 resultSet.close();
         statement.close();
         
    		return utente;
    	

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