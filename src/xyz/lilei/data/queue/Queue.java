package xyz.lilei.data.queue;

/**
 * @ClassName Queue
 * @Description TODO
 * @Author lilei
 * @Date 17/06/2019 20:16
 * @Version 1.0
 **/
public interface Queue<E>  {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();

}
