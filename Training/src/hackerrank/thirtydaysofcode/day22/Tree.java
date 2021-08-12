package hackerrank.thirtydaysofcode.day22;

public interface Tree<E extends Comparable> {

    boolean isEmpty();

    int cardinality();

    boolean member(E elt);

    NonEmptyBST<E> add(E element);

}
