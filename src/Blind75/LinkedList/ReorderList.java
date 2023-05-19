package Blind75.LinkedList;

import java.util.List;

public class ReorderList {

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

    public static ListNode reverseList(ListNode head) {
        // Write your code here.
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // find secondPart (half after middle)
        ListNode secondPart = slow;
        // Reverse the secondPart  1->2->3->4->5->6 to 1->2->3->6->5->4
        secondPart = reverseList(secondPart);

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        // find first part
        ListNode temp = head;
        while (temp.next != slow) {
            temp = temp.next;
        }
        temp.next = null;
        ListNode firstPart = head;
        // merge them
        ListNode dummy = new ListNode();
        ListNode iterator = dummy;
        while (firstPart != null && secondPart != null) {
            iterator.next = new ListNode(firstPart.val);
            iterator = iterator.next;
            firstPart = firstPart.next;
            iterator.next = new ListNode(secondPart.val);
            iterator = iterator.next;
            secondPart = secondPart.next;
        }
        if (firstPart == null) {
            while (secondPart != null) {
                iterator.next = new ListNode(secondPart.val);
                secondPart = secondPart.next;
            }
        } else {
            while (firstPart != null) {
                iterator.next = new ListNode(firstPart.val);
                firstPart = firstPart.next;
            }
        }
        head.next = dummy.next;
        head.next = head.next.next;
    }

    public static void printList(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        printList(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        printList(head);
    }
}
