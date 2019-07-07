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
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);


        System.out.println(segmentTree.query(2, 5));
        segmentTree.set(2, 10);
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.toString());
    }
}
