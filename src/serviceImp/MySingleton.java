package serviceImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySingleton {
	Connection conn;
	private static MySingleton m = null;

	public Connection getConn() {
		return conn;
	}

	private MySingleton() {

		String serveurBD = "jdbc:mysql://127.0.0.1:3306/bibliotheque?autoReconnect=true&useSSL=false";
		String login = "root";
		String motPasse = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(serveurBD, login, motPasse);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static MySingleton getInstance() {
		if (m == null)
			m = new MySingleton();
		return m;
	}
}
