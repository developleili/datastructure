package xyz.lilei.data.stack;

/**
 * @ClassName Stack
 * @Description TODO
 * @Author lilei
 * @Date 16/06/2019 17:41
 * @Version 1.0
 **/
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
