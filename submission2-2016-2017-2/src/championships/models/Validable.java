package championships.models;

public interface Validable<T> {
    boolean valid(T t);
}