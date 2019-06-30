package xyz.lilei.data.tree;

import java.util.Random;

/**
 * @ClassName main
 * @Description TODO
 * @Author lilei
 * @Date 25/06/2019 18:33
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 100; i++) {
            bst.add(new Random().nextInt(1000));
        }

        // 前序遍历
        bst.perOrder();
        System.out.println();

        // 中序遍历
        bst.inOrder();
        System.out.println();

        // 后序遍历
        bst.postOrder();
        System.out.println();
        System.out.println(bst.toString());
    }
}
