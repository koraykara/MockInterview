package Blind75.LinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedListsWithHeap {

    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class ListNodeComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            if(o1.val < o2.val)
                return -1;
            else if(o1.val > o2.val)
                return 1;
            return 0;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new ListNodeComparator());
        for(ListNode listNode: lists){
            if(listNode != null){
                priorityQueue.add(listNode);
            }
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (!priorityQueue.isEmpty()){
            ListNode min = priorityQueue.poll();
            if(min != null){
                temp.next = min;
                if(min.next != null){
                    priorityQueue.add(min.next);
                }
                temp = temp.next;
            }
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        printList(head.next);
    }

    public static void main(String[] args) {


        ListNode[] lists = {null, null, new ListNode(1)};
        printList(mergeKLists(lists));
    }
}
