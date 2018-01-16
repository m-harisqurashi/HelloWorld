
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnection {
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

	private String url;
	private String user;
	private String password;

	public JDBCConnection() {
		url = "jdbc:postgresql://localhost/mercurialminds";
		user = "postgres";
		password = "768S2rzb";
		initConnection();
	}

	public JDBCConnection(String dbName, String user, String password) {
		url = "jdbc:postgresql://localhost/"+dbName;
		this.user = user;
		this.password = password;
		initConnection();
	}
	
	public String runQuery(String query) {
		try {
			
			if (con == null) {
				con = DriverManager.getConnection(url, user, password);
			}
			
			st = con.createStatement();
			st.execute(query);
			/*
			rs = 
					

			if (rs.next()) {
				 return rs.getString(1);
			}*/

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(JDBCConnection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		} 
		return "Error";
	}
	
	public void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(JDBCConnection.class.getName());
			lgr.log(Level.WARNING, ex.getMessage(), ex);
		}
	}

	private void initConnection() {
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(JDBCConnection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}
	}
}
