package chapter3.generics;

import chapter3.generics.beans.Robot;

/**
 * Generic interface
 * 
 * @author root
 *
 * @param <T>
 */
public interface Shippable<T> {
	void ship(T t);
}

/**
 * Implementation using an specific type. In this case Robot
 * @author root
 *
 */
class ShippableRobotCrate implements Shippable<Robot> {
	public void ship(Robot t) { }
}

/**
 * Implementation inheriting the generic characteristic 
 * @author root
 *
 * @param <U>
 */
class ShippableAbstractCrate<U> implements Shippable<U> {
	public void ship(U t) { }
}

/**
 * 
 * @author root
 *
 */
class ShippableCrate implements Shippable {
	public void ship(Object t) { }
}