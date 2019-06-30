package xyz.lilei.data.map;

import xyz.lilei.data.tree.BST;

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
        BSTMap<Integer, Integer> map = new BSTMap<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            map.add(random.nextInt(10), random.nextInt(10));
        }
        map.postOrder();
        System.out.println();
        map.set(1,map.get(8).intValue());
        System.out.println(map.remove(2));
        map.postOrder();
        System.out.println();
        System.out.println("size " + map.getSize());
    }
}
