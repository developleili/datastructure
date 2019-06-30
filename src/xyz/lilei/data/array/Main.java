package xyz.lilei.data.array;

import xyz.lilei.data.queue.ArrayQueue;
import xyz.lilei.data.queue.LoopQueue;
import xyz.lilei.data.queue.Queue;

import java.util.Random;

/**
 * @ClassName Main
 * @Description TODO
 * @Author lilei
 * @Date 16/06/2019 11:38
 * @Version 1.0
 **/
public class Main {

    private static double testQueue(Queue<Integer> q, int opCount ){

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0 ; i < opCount ; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0 ; i < opCount ; i++)
            q.dequeue();

        Long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> a = new ArrayQueue<>();
        System.out.println("time :" +testQueue(a, opCount));

        LoopQueue<Integer> l = new LoopQueue<>();
        System.out.println("time :" +testQueue(l, opCount));
    }
}
