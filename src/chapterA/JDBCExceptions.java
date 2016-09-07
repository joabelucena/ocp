package chapterA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lib.TextElements;

public class JDBCExceptions extends TextElements {

	public static void main(String[] args) {

		String url = "jdbc:firebirdsql:localhost/3050:/data/zoo.fdb";

		try (Connection conn = DriverManager.getConnection(url, "SYSDBA",
				"masterkey");
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery("select not_a_column from animal")) {

		} catch(SQLException e ) {
			System.out.println("Message: " + e.getMessage());
			separe();
			
			System.out.println("SQL State: " + e.getSQLState());
			
			separe();
			System.out.println("Error code: " + e.getErrorCode());
		}

	}

}
