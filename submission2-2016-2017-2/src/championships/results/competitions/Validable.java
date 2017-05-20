package championships.results.competitions;

public interface Validable<T> {

    /**
     *
     * @param object gets checked by the rules of the implementing class
     * @return true if the object is valid
     */
    boolean valid(T object);
}