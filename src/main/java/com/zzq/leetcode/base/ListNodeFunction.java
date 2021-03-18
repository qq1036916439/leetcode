package com.zzq.leetcode.base;

/**
 * @author zhangzhiqiang
 */
public class ListNodeFunction {

    public static com.zzq.listNode.ListNode arrayToListNode(int... val) {
        com.zzq.listNode.ListNode head = new com.zzq.listNode.ListNode(0);
        com.zzq.listNode.ListNode curr = head;
        for (int i : val) {
            curr.next = new com.zzq.listNode.ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }

    /**
     * 按照顺序输出链表
     * @param node
     * @return
     */
    public static void printListNode(com.zzq.listNode.ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static com.zzq.listNode.ListNode reverseBetween(com.zzq.listNode.ListNode head, int m, int n) {
        com.zzq.listNode.ListNode curr=head;
        com.zzq.listNode.ListNode pre=new com.zzq.listNode.ListNode();
        com.zzq.listNode.ListNode next=null;
        for(int i=1;i<m;i++){
            pre=curr;
            curr=curr.next;
        }
        com.zzq.listNode.ListNode preNode=pre;
        for(int j=1;j<n-m;j++){
            next=curr.next;
            curr.next=preNode;
            preNode=curr;
            curr=next;
        }

        return head;
    }

    public static void main(String[] args) {
        com.zzq.listNode.ListNode listNode = arrayToListNode(1, 2, 3, 4, 5);
        reverseBetween(listNode,2,4);
    }


}
