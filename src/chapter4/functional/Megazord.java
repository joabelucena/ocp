package chapter4.functional;

@FunctionalInterface
public interface Megazord<T,U,V,R> {
	R apply(T t, U u, V v);
}
