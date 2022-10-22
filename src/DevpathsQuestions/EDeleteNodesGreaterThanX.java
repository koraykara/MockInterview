package DevpathsQuestions;

public class EDeleteNodesGreaterThanX {

    // Definition for a binary tree node.
    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }

    public static SinglyLinkedListNode removeNodes(SinglyLinkedListNode listHead, int x){
        if(listHead == null) return null;
        SinglyLinkedListNode tempNode = listHead;

        while (tempNode != null && tempNode.data > x) {
            tempNode = tempNode.next;
            listHead = tempNode;
        }

        tempNode = listHead;
        SinglyLinkedListNode previousNode = tempNode;

        while(tempNode != null){
            while (tempNode != null && tempNode.data < x) {
                previousNode = tempNode;
                tempNode = tempNode.next;
            }
            if (tempNode == null) break;
            previousNode.next = tempNode.next;
            tempNode = previousNode.next;
        }
        return listHead;
    }

    public static SinglyLinkedListNode remove(SinglyLinkedListNode listHead, SinglyLinkedListNode removedNode){
        if(removedNode.equals(listHead) || listHead.next == null) listHead = removeBeginning(listHead);

        SinglyLinkedListNode temp = listHead;
        while(temp.next != null){
            if(temp.next.next == null){
                if(temp.next.equals(removedNode)) {
                    temp.next = null;
                }
            }
            else {
                if (temp.next.equals(removedNode)) {
                    temp.next = removedNode.next;
                }
            }
            if(temp.next != null)
                temp = temp.next;
        }
        return listHead;
    }

    public static SinglyLinkedListNode removeEnd(SinglyLinkedListNode listHead){
        if(listHead == null) return null;

        if(listHead.next == null) {
            listHead = removeBeginning(listHead);
            return listHead;
        }

        SinglyLinkedListNode temp = listHead;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return listHead;
    }

    public static int findNumberOfElementsInTheList(SinglyLinkedListNode listHead){
        int count = 0;
        while(listHead != null){
            count += 1;
            listHead = listHead.next;
        }
        return count;
    }

    public static SinglyLinkedListNode removeBeginning(SinglyLinkedListNode listHead){
        if(listHead == null) return null;
        SinglyLinkedListNode temp = listHead;
        temp = temp.next;
        listHead = temp;
        return listHead;
    }



    public static void printList(SinglyLinkedListNode listHead){
        while(listHead != null){
            System.out.print(listHead.data + " -> ");
            listHead = listHead.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedListNode listHead = new SinglyLinkedListNode();
        listHead.data = 5;
        listHead.next = new SinglyLinkedListNode();
        listHead.next.data = 5;
        listHead.next.next = new SinglyLinkedListNode();
        listHead.next.next.data = 2;
        listHead.next.next.next = new SinglyLinkedListNode();
        listHead.next.next.next.data = 1;
        listHead.next.next.next.next = new SinglyLinkedListNode();
        listHead.next.next.next.next.data = 6;
        listHead.next.next.next.next.next = new SinglyLinkedListNode();
        listHead.next.next.next.next.next.data = 7;
        listHead.next.next.next.next.next.next = new SinglyLinkedListNode();
        listHead.next.next.next.next.next.next.data = 5;

        printList(listHead);
        listHead = removeNodes(listHead, 3);
        printList(listHead);
    }
}
