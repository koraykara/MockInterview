package Blind75.LinkedList;

public class MergeTwoSortedLists {

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

    // A little bit bad solution
    // Adding a node to end all the time

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null ) return list2;
        if(list2 == null) return list1;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode ret = null;

        do {
            if (p1.val < p2.val) {
                ret = addToEnd(ret, p1.val);
                p1 = p1.next;
            } else if (p2.val < p1.val) {
                ret = addToEnd(ret, p2.val);
                p2 = p2.next;
            } else {
                ret = addToEnd(ret, p1.val);
                p1 = p1.next;
            }
        } while (p1 != null && p2 != null);

        if (p1 == null) {
            while (p2 != null){
                ret = addToEnd(ret, p2.val);
                p2 = p2.next;
            }
        }
        else {
            while (p1 != null){
                ret = addToEnd(ret, p1.val);
                p1 = p1.next;
            }
        }
        return ret;
    }

    public static ListNode addToEnd(ListNode head, int val){
        if(head == null){
            head = new ListNode(val);
            return head;
        }
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        return head;
    }

    // Much better solution
    public static ListNode mergeTwoListsGood(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode();
        ListNode temp  = dummy;
        while (list1 != null && list2 != null){
            if(list1.val == list2.val){
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else if(list1.val < list2.val){
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else{
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 == null){
            while (list2 != null){
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
                temp = temp.next;
            }
        }
        else {
            while (list1 != null){
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
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
        ListNode head = new ListNode(2);

        ListNode head2 = new ListNode(1);

        printList(mergeTwoListsGood(head, head2));
    }
}
