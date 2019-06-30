package xyz.lilei.data.queue;

import xyz.lilei.data.array.Array;

/**
 * @ClassName ArratQueue
 * @Description TODO
 * @Author lilei
 * @Date 17/06/2019 20:29
 * @Version 1.0
 **/
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue (){
        array = new Array<>();
    }

    public ArrayQueue (int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i)+", ");
            if (i == array.getSize()-1)
                res.append(array.get(i)+"] tail");
        }
        return res.toString();
    }
}
