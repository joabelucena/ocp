package chapterA;

import java.sql.*;

import lib.TextElements;

public class MyFirstDatabaseConnection extends TextElements {

	public static void main(String... args) throws SQLException {
		String url = "jdbc:firebirdsql:localhost/3050:/data/zoo.fdb";

		try (Connection conn = DriverManager.getConnection(url, "SYSDBA",
				"masterkey");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from animal")) {

			ResultSetMetaData meta = rs.getMetaData();
			
			System.out.println("Printing data for: animal");
			
			separe();

			while (rs.next()) {

				for (int i = 1; i < meta.getColumnCount(); i++)
					System.out.print(meta.getColumnName(i) + ": "
							+ rs.getObject(i) + "\t");

				System.out.println();

			}
		}
	}
}
