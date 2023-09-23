package SDESheet.LinkedList;

import SDESheet.LinkedList.DefinitionOfLinkedList.ListNode;

import static SDESheet.LinkedList.DefinitionOfLinkedList.ListNode.printList;

public class ReverseALinkedList {

    public static ListNode reverseList(ListNode head) {
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
    }
}
