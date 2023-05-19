package Blind75.LinkedList;

public class MergeKSortedList {

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

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode first = lists[0];
        ListNode second = lists[1];
        int index = 0;
        while (index < lists.length) {
            first = mergeTwoLists(first, second);
            if(index + 2 >= lists.length) break;
            second = lists[index+2];
            index++;
        }
        return first;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val == list2.val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 == null) {
            while (list2 != null) {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
                temp = temp.next;
            }
        } else {
            while (list1 != null) {
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
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};
        printList(mergeKLists(lists));
    }
}
