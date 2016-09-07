package chapterA;

import java.sql.*;

public class MyFirstDatabaseConnection  {
	
	public static void main(String...args) throws SQLException {
		String url = "jdbc:firebirdsql:localhost/3050:/data/zoo.fdb";
		
		try(Connection conn = DriverManager.getConnection(url, "SYSDBA", "masterkey");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from animal")) {
		
			while(rs.next()) {
				FOR_LOOP: for(int i = 1; i < Integer.MAX_VALUE; i++) {
					try {
						System.out.print(rs.getObject(i) + "\t");
					} catch (Exception e) {
						System.out.println();
						break FOR_LOOP;
					}
				}
			}
			
		}
	}
}
