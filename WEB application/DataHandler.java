package jsp_azure_test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataHandler1 {
	private Connection conn;
	private String server = "sagi0000-sql-server.database.windows.net"; 
	private String database = "cs-dsa-4513-sql-db"; 
	private String username = "sagi0000"; 
	private String password  = "Avinash8&65";
	// Resulting connection string
	final private String url =
			String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;host "
			+ "NameInCertificate=*.database.windows.net;loginTimeout=30;",
			server, database, username, password);
	// Initialize and save the database connection
	private void getDBConnection() throws SQLException {
	if (conn != null) {
		return;
	}
	          this.conn = DriverManager.getConnection(url);
	}

	// Return the result of selecting everything from the movie_night table
	public ResultSet getAllCustomers() throws SQLException {
			getDBConnection();
			final String sqlQuery = "SELECT * FROM customer;";
			final PreparedStatement stmt = conn.prepareStatement(sqlQuery);
	return stmt.executeQuery();
	}
	
	// Inserts a record into the customer table with the given attribute values
	public boolean addCustomer(
					String name, String address, int category) throws SQLException {
			getDBConnection(); // Prepare the database connection
	// Prepare the SQL statement
			final String sqlQuery =
	"INSERT INTO customer " +
	"(name, address, category) " +
	"VALUES " +
	"(?, ?, ?)";
			final PreparedStatement stmt = conn.prepareStatement(sqlQuery);
	// Replace the '?' in the above statement with the given attribute values
			stmt.setString(1, name);
			stmt.setString(2, address);
			stmt.setInt(3, category);
	// Execute the query, if only one record is updated, then we indicate success byreturning true
	return stmt.executeUpdate() == 1;
	}
	
	// Return the result of selecting everything from the movie_night table
		public ResultSet retrieveCustomers(int min_cat, int max_cat) throws SQLException {
				getDBConnection();
				final String sqlQuery = "SELECT * FROM customer WHERE category BETWEEN '" + min_cat + "' and '" + max_cat + "'";;
				final PreparedStatement stmt = conn.prepareStatement(sqlQuery);
		return stmt.executeQuery();
		}
	
	
}
