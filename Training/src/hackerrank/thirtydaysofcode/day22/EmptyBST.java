package hackerrank.thirtydaysofcode.day22;

public class EmptyBST<E extends Comparable> implements Tree<E> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int cardinality() {
        return 0;
    }

    @Override
    public boolean member(E elt) {
        return false;
    }

    @Override
    public NonEmptyBST<E> add(E element) {
        return new NonEmptyBST(element);
    }
}
