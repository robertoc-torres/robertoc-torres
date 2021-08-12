package hackerrank.thirtydaysofcode.day22;

/*

    Day 22: Binary Search Trees
    https://www.hackerrank.com/challenges/30-binary-search-trees/tutorial

 */

public class NonEmptyBST<E extends Comparable> implements Tree<E>{

    E data;
    Tree<E> left;
    Tree<E> right;

    NonEmptyBST(E element) {
        data = element;
        left = new EmptyBST<E>();
        right = new EmptyBST<E>();
    }

    NonEmptyBST(E element, Tree<E> leftTree, Tree<E> rightTree) {
        data = element;
        left = leftTree;
        right = rightTree;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality();
    }

    @Override
    public boolean member(E elt) {
        if(data == elt) {
            return true;
        } if(data.compareTo(elt) < 0) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }

    @Override
    public NonEmptyBST<E> add(E element) {
        if(data.compareTo(element) == 0) {
            return this;
        }
        if(data.compareTo(element) < 0) {
            return new NonEmptyBST<>(data, left.add(element), right);
        } else {
            return new NonEmptyBST<>(data, left, right.add(element));
        }
    }
}
