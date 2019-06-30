package xyz.lilei.data.stack;

import xyz.lilei.data.linkedlist.LinkedList;

/**
 * @ClassName LinkedListStack
 * @Description TODO
 * @Author lilei
 * @Date 18/06/2019 21:36
 * @Version 1.0
 **/
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListStack<Integer> linkedList = new LinkedListStack<>();
        for (int i = 0; i < 8; i++) {
            linkedList.push(i);
            System.out.println(linkedList.toString());
        }

        linkedList.pop();
        System.out.println(linkedList);
    }

}
