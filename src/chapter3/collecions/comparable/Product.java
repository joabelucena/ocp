package chapter3.collecions.comparable;

/**
 * Low consistency Comparable class
 * @author root
 *
 */
public class Product implements Comparable<Product> {
	
	int id;
	String name;
	
	/**
	 * equals() consider only id field for two objects beeing equal 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		
		return id == other.id;
	}
	
	/**
	 * compareTo() is considering name field. Both method should compare the same fields for staying
	 * on rule that x.equals(y) return 0;
	 */
	@Override
	public int compareTo(Product o) {
		return this.name.compareTo(o.name); 
	}

}
