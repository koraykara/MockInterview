package Others;

public class RemoveNthNodeFromEndofList {

     // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode removeFirstNode(ListNode head){
        ListNode temp = head;
        head = temp.next;
        return head;
    }

    public static ListNode removeLastNode(ListNode head){
        ListNode temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
          ListNode nthNodeFromEnd = findNthFromEnd(head,n);
          System.out.println("removed " + nthNodeFromEnd.val);

          if(head.next == null || nthNodeFromEnd.equals(head)){ // case of removing first node
              head = removeFirstNode(head);
          }
          if(n == 1){ // case of removing last element
              head = removeLastNode(head);
          }

          /*
          The case of removing the kth node from the end
           */
          ListNode temp = head;
          while(temp.next != null){
              if(temp.next.equals(nthNodeFromEnd)){
                  temp.next = temp.next.next;
              }
              temp = temp.next;
          }


          return head;
    }



    public static ListNode findNthFromEnd(ListNode head, int n){
        if(head.next == null)
            return head;
        ListNode first = head;
        ListNode second = first;
        for(int i=0;i<n;i++){
            second = second.next;
        }
        while (second != null)
        {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public static void printList(ListNode head){
          while(head != null){
              System.out.print(head.val);
              head = head.next;
          }
        System.out.println();
    }

    public static void main(String[] args) {
          ListNode node = new ListNode(1);
          node.next = new ListNode(2);
          node.next.next = new ListNode(3);
          node.next.next.next = new ListNode(4);
          node.next.next.next.next = new ListNode(5);

        printList(node);
        System.out.println(removeNthFromEnd(node, 5).val);

        node = removeNthFromEnd(node, 1);
        printList(node);
    }
}
