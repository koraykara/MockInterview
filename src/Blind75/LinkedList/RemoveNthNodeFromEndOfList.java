package Blind75.LinkedList;

import javax.swing.event.ListDataEvent;

public class RemoveNthNodeFromEndOfList {

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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (head.next == null) return null;
        return delete(head, n);
    }

    public static ListNode delete(ListNode head, int n) {
        ListNode ret = head;
        if (n == 1) {
            return deleteEnd(head);
        } else {
            ListNode p1 = head;
            ListNode p2 = head;
            for (int i = 0; i < n; i++) {
                p2 = p2.next;
            }
            if(p2 == null){
                ListNode temp = p1;
                temp = temp.next;
                head = temp;
                return head;
            }
            else {
                while (p2.next != null) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                ListNode prev = p1;
                ListNode deleted = prev.next;
                prev.next = deleted.next;
            }
        }
        return ret;
    }

    public static ListNode deleteEnd(ListNode head) {
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static void printList(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        printList(head.next);
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        int n = 1;
        printList(removeNthFromEnd(list, n));

    }
}
