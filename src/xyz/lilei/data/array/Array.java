package xyz.lilei.data.array;

/**
 * @ClassName Array
 * @Description  基于java数组进行二次封装
 * @Author lilei
 * @Date 16/06/2019 11:09
 * @Version 1.0
 **/

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }


    public int getSize() {
        return size;
    }

    // 判断是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 增加一个元素
    public void addLast(E e){
        if (size == data.length)
            resize(2 * data.length);
        data[size++] = e;
    }

    //指定索引增加元素
    public void add(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size.");

        if (size == data.length){
            resize(2 * data.length);
        }

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        for (int i = size -1; i >= index ; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 在数组开头增加元素
    public void addFirst(E e){
        add(0, e);
    }

    // 获得指定索引元素
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找元素e所在索引
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal");
        E ret = data[index];
        for (int i = index +1 ; i < size ; i++)
            data[i-1] = data[i];
        size--;
        data[size] = null; // loitering objects != memory leak
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    // 删除指定元素
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    // 修改指定索引元素
    public void set(int index, E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal");
        data[index] = e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size -1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
