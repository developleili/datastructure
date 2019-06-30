package xyz.lilei.data.stack;

import xyz.lilei.data.array.Array;

/**
 * @ClassName ArrayStack
 * @Description TODO
 * @Author lilei
 * @Date 16/06/2019 17:44
 * @Version 1.0
 **/
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(){
        this(10);
    }

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
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
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i)+", ");
            if (i == array.getSize()-1)
                res.append(array.get(i)+"] top");
        }
        return res.toString();
    }
}
