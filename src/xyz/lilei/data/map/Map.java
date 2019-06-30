package xyz.lilei.data.map;

/**
 * @ClassName Map
 * @Description TODO 映射
 * @Author lilei
 * @Date 26/06/2019 22:56
 * @Version 1.0
 **/
public interface Map<K, V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
