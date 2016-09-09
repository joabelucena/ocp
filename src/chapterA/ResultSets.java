package chapterA;

import java.sql.*;
import java.time.*;
import java.util.*;

import lib.TextElements;

public class ResultSets extends TextElements {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:firebirdsql:localhost/3050:/data/zoo.fdb";

		try (Connection conn = DriverManager.getConnection(url, "SYSDBA",
				"masterkey"); Statement stm = conn.createStatement()) {

			{
				Map<Integer, String> idToNameMap = new HashMap<>();
				ResultSet rs = stm.executeQuery("select id, name from species");

				/*
				 * get with names
				 */
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					idToNameMap.put(id, name);
				}

				System.out.println(idToNameMap);

				miniSepare();

				rs = stm.executeQuery("select id, name from species");

				/*
				 * get with index
				 */
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					idToNameMap.put(id, name);
				}

				System.out.println(idToNameMap);
			}

			separe();

			{
				/*
				 * Returning just one row as sum(), count(), avg(), etc
				 */

				ResultSet rs = stm.executeQuery("select count(*) from animal");

				if (rs.next())
					System.out.println("There is (are) " + rs.getInt("count")
							+ " animal(s)");
			}

			separe();

			{
				/*
				 * Working with Dates
				 */
				ResultSet rs = stm
						.executeQuery("select date_born from animal where name = 'Elsa'");
				if (rs.next()) {

					java.sql.Timestamp sqlTimestamp = rs.getTimestamp(1);
					LocalDateTime localDateTime = sqlTimestamp
							.toLocalDateTime();

					System.out.println(localDateTime);
					miniSepare();

					// Get date
					java.sql.Date sqlDate = rs.getDate(1);
					LocalDate localDate = sqlDate.toLocalDate();

					System.out.println(localDate);

					miniSepare();

					// Get Time
					java.sql.Time sqlTime = rs.getTime(1);
					LocalTime localTime = sqlTime.toLocalTime();

					System.out.println(localTime);

				}

			}

			separe();

			{
				/*
				 * getObject()
				 */
				ResultSet rs = stm.executeQuery("select id, name from species");
				while (rs.next()) {
					Object idField = rs.getObject(1);
					Object nameField = rs.getObject(2);

					if (idField instanceof Integer) {
						int id = (Integer) idField;
						System.out.print(id + " - ");
					}

					if (nameField instanceof String) {
						String name = (String) nameField;
						System.out.println(name);
					}
				}
			}

			separe();

			{
				/*
				 * Scrolling ResultSets
				 */
				try (Statement scroll = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY)) {
					ResultSet rs = scroll
							.executeQuery("select id from species order by id");
					
					System.out.println("Printing table for: select id from species order by id");
					printTable(rs);
					
					miniSepare();
					
					rs.beforeFirst();
					
					rs.afterLast();
					
					System.out.print(rs.previous() + " - ");
					System.out.println(rs.getInt(1));
					System.out.print(rs.previous() + " - ");
					System.out.println(rs.getInt(1));
					System.out.print(rs.last() + " - ");
					System.out.println(rs.getInt(1));
					System.out.print(rs.first() + " - ");
					System.out.println(rs.getInt(1));
					
					rs = scroll
							.executeQuery("select id from species where id = -99");
					
					System.out.println(rs.first());
					System.out.println(rs.last());
					

				}
			}
			
			separe();
			
			{
				/*
				 * absolute()
				 */
				try (Statement scroll = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY)) {
					ResultSet rs = scroll
							.executeQuery("select * from animal order by id");
					
					System.out.println("Printing table for: select id from species order by id");
					printTable(rs);
					
					miniSepare();
					
					System.out.print(rs.absolute(2) + ": ");
					System.out.println(rs.getString("id"));		// 2
//					System.out.print(rs.absolute(0) + ": ");	// Firebird throws Exception =/
					System.out.print(rs.absolute(5) + ": ");
					System.out.println(rs.getString("id"));		// 5
					System.out.print(rs.absolute(-2) + ": ");
					System.out.println(rs.getString("id"));		// 4
					
					
					miniSepare();
					
					rs.beforeFirst();
					
					System.out.print(rs.next() + ": ");
					System.out.println(rs.getString("id"));		// 1
					System.out.print(rs.relative(2) + ": ");
					System.out.println(rs.getString("id"));		// 3
					System.out.print(rs.relative(-1) + ": ");
					System.out.println(rs.getString("id"));		// 2
					System.out.print(rs.relative(4) + ": ");
					

				}
			}

		}

	}
	
	
	public static void printTable(ResultSet rs) throws Exception {
		
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
