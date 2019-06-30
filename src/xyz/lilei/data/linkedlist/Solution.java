package xyz.lilei.data.linkedlist;

import javax.sound.midi.SoundbankResource;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author lilei
 * @Date 20/06/2019 23:13
 * @Version 1.0
 **/
public class Solution {
    public ListNode removeElements(ListNode head, int val){

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }
            else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {6,6,1,2,6,3,4,6,5};
        ListNode res = new ListNode(arr);
        System.out.println(res.toString());
        Solution solution = new Solution();
        // ListNode res = solution.removeElements(listNode, 6);
        while (res.next != null){
            System.out.print(res.val + "->");
            res = res.next;
            if (res.next ==null){
                System.out.println(res.val);
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] arr) {
        if (arr.length == 0 || arr == null)
            throw new IllegalArgumentException("transFrom failed, please introduction you array");
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        ListNode dummyHead = this;
        for (ListNode cur = dummyHead; cur != null ; cur = cur.next)
            res.append(cur.val + "->");
        res.append("NULL");

        return res.toString();
    }
}

