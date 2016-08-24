package chapter6;

import static lib.TextElements.separe;

class JammedTurkeyCage implements AutoCloseable {
	public void close() throws IllegalStateException {

		// 3 - This method throw a new Exception. Throughout there's already a
		// threw Exception,
		// this one is added as a suppressed exception
		throw new IllegalStateException("Cage door does not close");
	}
}

public class SuppressedExceptions {

	public static void main(String[] args) {
		
		{
			/*
			 * Suppressed example 1
			 */
			try (JammedTurkeyCage t = new JammedTurkeyCage()) {

				// 1 - Throw exception and try clause ends
				throw new IllegalStateException("Turkeys ran of");

			} catch (IllegalStateException e) { // 2 - At this line, the close() method is called

				// 4 - Here it prints the exception that was caught at first
				System.out.println("caught: " + e.getMessage());

				// 5 - Then it prints the suppressed exceptions
				for (Throwable t : e.getSuppressed()) {
					System.out.println(t.getMessage());
				}
			}

		}
		
		separe();
		
		{
			/*
			 * Suppressed example 2
			 */
			try (JammedTurkeyCage t = new JammedTurkeyCage()) {
//				throw new RuntimeException("turkeys ran off");		// Comment for running other examples
				
			} catch (IllegalStateException e) { // 2 - At this line, the close() method is called

				// 4 - Here it prints the exception that was caught at first
				System.out.println("caught: " + e.getMessage());

			}
		}
		
		separe();
		
		{
			/*
			 * Suppressed example 3
			 */
			try (JammedTurkeyCage t1 = new JammedTurkeyCage();
					JammedTurkeyCage t2 = new JammedTurkeyCage()) {

				// 1 - Throw exception and try clause ends
				System.out.println("Turkeys entered cages");

			} catch (IllegalStateException e) { // 2 - At this line, the close() method is called

				// 4 - Here it prints the exception that was caught at first
				System.out.println("caught: " + e.getMessage());

				// 5 - Then it prints the suppressed exceptions
				for (Throwable t : e.getSuppressed()) {
					System.out.println(t.getMessage());
				}
			}
		}
		
		separe();
		
		/*
		 * Suppressed example 4
		 */
		try (JammedTurkeyCage t = new JammedTurkeyCage()) {

			// 1 - Throw exception and try clause ends
			throw new IllegalStateException("Turkeys ran of");

		} finally {
			throw new RuntimeException("and we couldn't find them");
		}

	}

}
