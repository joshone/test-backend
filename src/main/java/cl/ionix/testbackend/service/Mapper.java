package cl.ionix.testbackend.service;

@FunctionalInterface
public interface Mapper<R, T> {
	
	public R apply (T t);

}
