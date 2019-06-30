package xyz.lilei.data.tree;

/**
 * @ClassName Set
 * @Description TODO
 * @Author lilei
 * @Date 26/06/2019 21:06
 * @Version 1.0
 **/
public interface Set <E>{

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
