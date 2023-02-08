package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtileConnection {
	public static Connection seConnecter() {
		
		String DRIVER="org.postgresql.Driver";
		String URL="jdbc:postgresql://localhost:5432/Leboncoin";
		String LOGIN="postgres";
		String PASSWORD="Java2023";
		Connection connection = null;
		
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,LOGIN,PASSWORD);
		}catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e1) {
			
		}
		
		return connection;
		
	}
	public static void main(String[] args) throws SQLException {
	System.out.println("Open connection");
	Connection con = UtileConnection.seConnecter();
	con.close();
	System.out.println("Connection close");
	}
}
