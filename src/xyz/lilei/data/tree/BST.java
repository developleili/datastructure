package xyz.lilei.data.tree;

/**
 * @ClassName BST
 * @Description TODO
 * @Author lilei
 * @Date 25/06/2019 16:13
 * @Version 1.0
 **/
public class BST <E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST (){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size== 0 ;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e,递归算法
    // 返回插入新节点后的二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else
            node.left = add(node.left, e);
        return node;
    }

    // 搜索二分搜索树是否包含元素e
    public boolean contains(E e){
        return contains(root ,e);
    }

    private boolean contains(Node node, E e){
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0){
            return true;
        }
        else if (e.compareTo(node.e) > 0)
            return contains(node.right, e);
        else
            return contains(node.left, e);
    }

    // 前序遍历
    public void perOrder(){
        perOrder(root);
    }

    // 递归写法
    private void perOrder(Node node){
        if (node != null){
            System.out.print(node.e+" ");
            perOrder(node.left);
            perOrder(node.right);
        }
    }

    // 中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.e+" ");
        inOrder(node.right);
    }

    // 后续遍历
    public void  postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.e + " ");
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    // 生成以node为根节点, 深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    // 返回最小元素
    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 返回最大元素
    public E maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点,返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

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

    // 从二分搜索树中删除最大值所在节点,返回最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){

        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size -- ;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e){
        if (node == null){
            return null;
        }

        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else { // e == node.e
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }


}
