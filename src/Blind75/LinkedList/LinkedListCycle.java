package Blind75.LinkedList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCycle {

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

    // First solution
    // By using Set to check whether I visit the node before or not
    // Time: O(n)
    // Space: O(n)
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (visited.contains(temp)) {
                return true;
            }
            visited.add(temp);
            temp = temp.next;
        }
        return false;
    }

    // Second solution
    // By using slow and fast pointers
    // Time: O(n)
    // Space: O(1)
    public static boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        do {
            if(fast.next != null) {
                fast = fast.next.next;
            }
            else {
                return false;
            }
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        } while (fast != null && slow != null);
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(hasCycle2(head));
    }
}
