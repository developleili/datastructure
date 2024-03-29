package xyz.lilei.data.tree;

/**
 * @ClassName BSTSet
 * @Description TODO
 * @Author lilei
 * @Date 26/06/2019 21:08
 * @Version 1.0
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E>{

    private BST<E> bst;

    public BSTSet(){
        bst = new BST<>();
    }
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty() ;
    }
}
