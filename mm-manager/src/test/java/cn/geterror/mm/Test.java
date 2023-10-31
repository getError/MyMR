package cn.geterror.mm;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fst = head;

        ListNode v_head = new ListNode();
        v_head.next = head;
        ListNode snd = v_head;
        for (int i = 0; i < n; i++) {
            if(fst==null){
                return head;
            }
            fst=fst.next;
        }
        while (fst!=null){
            fst=fst.next;
            snd=snd.next;
        }
        if(snd.next!=null){
            snd.next = snd.next.next;
        }else {
            snd.next = null;
        }
        return v_head.next;

    }
}

public class Test {
}