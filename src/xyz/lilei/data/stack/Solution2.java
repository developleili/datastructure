package xyz.lilei.data.stack;

import java.util.List;

/**
 * @ClassName Solution2
 * @Description TODO
 * @Author lilei
 * @Date 25/06/2019 13:44
 * @Version 1.0
 **/
public class Solution2 {
    public ListNode removeElements(ListNode head, int val){
        if (head == null)
            return null;
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next:head;
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
