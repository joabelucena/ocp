package chapterA;

import java.sql.*;
import java.util.Properties;

import lib.TextElements;

public class TestClass extends TextElements {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		String url = "jdbc:firebirdsql:localhost/3050:/data/zoo.fdb";

		try (Connection conn = DriverManager.getConnection(url, "SYSDBA",
				"masterkey"); Statement stm = conn.createStatement()) {

			System.out.println("URL: " + url);

			separe();

			{
				/**
				 * Using Class.forName() in legacy code
				 */

				/*
				 * Loads a class in case of the driver not having a META-INF
				 * Driver class
				 */
				Class.forName("org.firebirdsql.jdbc.FBDriver");

				Connection connection = DriverManager.getConnection(url,
						"SYSDBA", "masterkey");

				System.out.println(connection);
			}

			separe();

			{
				/**
				 * ResultSet executeUpdate(String sql) throws SQLException
				 */

				int result = stm
						.executeUpdate("delete from species where id = 10");
				System.out.println("Deleted rows: " + result);

				result = stm
						.executeUpdate("insert into species values(10, 'Deer', 3)");
				System.out.println("Inserted rows: " + result);

				result = stm
						.executeUpdate("update species set name = '' where name = 'None'");
				System.out.println("Updated rows: " + result);

				result = stm.executeUpdate("delete from species where id = 10");
				System.out.println("Deleted rows: " + result);
			}

			separe();

			{
				/**
				 * ResultSet executeQuery(String sql) throws SQLException
				 */
				ResultSet rs = stm.executeQuery("select * from species");
			}

			separe();

			{
				boolean isResultSet = stm.execute("select * from species");

				if (isResultSet) {
					ResultSet rs = stm.getResultSet();
					System.out.println("ran a query");
				} else {
					int result = stm.getUpdateCount();
					System.out.println("ran an update");
				}
			}
			
			separe();
			
			{
				Properties p = new Properties();
				p.setProperty("user", "SYSDBA");
				p.setProperty("password", "masterkey");
				Connection c = DriverManager.getConnection(url, p);
				
				c.close();
			}

		}

	}

}
