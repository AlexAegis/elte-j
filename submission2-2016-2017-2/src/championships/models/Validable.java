package championships.models;

public interface Validable<T> {

    /**
     * Validator
     * @param t input
     * @return true if t is valid
     */
    boolean valid(T t);
}