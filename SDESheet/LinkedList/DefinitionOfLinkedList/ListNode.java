package SDESheet.LinkedList.DefinitionOfLinkedList;


import Blind75.Tree.BinaryTreeLevelOrderTraversal;

//  Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head){
        if(head == null) return;
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
