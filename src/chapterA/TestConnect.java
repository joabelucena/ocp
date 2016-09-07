package chapterA;

import java.sql.*;

public class TestConnect {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:firebirdsql:localhost/3050:/data/zoo.fdb";
		
		try(Connection conn = DriverManager.getConnection(url, "SYSDBA", "masterkey")){
			System.out.println(conn);	
		}
	}
}
