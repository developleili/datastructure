package xyz.lilei.data.map;

import com.sun.org.apache.bcel.internal.generic.NEW;
import xyz.lilei.data.tree.BST;

/**
 * @ClassName BSTMap
 * @Description TODO
 * @Author lilei
 * @Date 30/06/2019 08:33
 * @Version 1.0
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    public class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node (K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    // 向二分搜索树添加新的元素(key, value)
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素(key, value), 递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){

        if (node == null){
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }else
            node.value = value;
        return node;
    }

    // 返回以node为根节点的二分搜索树中, key所在的节点
    private Node getNode(Node node, K key){
        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0){
            return node;
        }
        else if (key.compareTo(node.key) > 0){
            return getNode(node.right, key);
        }
        else
            return getNode(node.left, key);
    }


    @Override
    public boolean contains(K key) {
        return getNode( root, key) == null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null?null : node.value;
    }

    // 设置二分搜索树中指定key的新值
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue ;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    // 从二分搜索树中删除键为key的节点
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    // 删除掉以node为根的二分搜索树中键为key的节点, 递归算法
    // 返回删除节点后新的root
    private Node remove(Node node, K key){
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        else{
            // 左子树为空的情况
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size -- ;
                return rightNode;
            }

            // 右子树为空的情况
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size -- ;
                return leftNode;
            }

            // 左右子树都不为空的情况
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
        }
        return node;
    }

    // 移除键最小的节点
    private Node removeMin(Node node){

        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size -- ;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 找到键最大的节点
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 后续遍历
    public void  postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + ": " + node.value + " ");
        }
    }
}
