package Chapter2_LinkedList.PrintPublicLinkedListSection;

/**
 * 【题目】
 *      打印两个有序链表的公共部分
 *
 *      给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 *
 *
 *
 *
 */

class Node{
    int val;
    Node next;
    Node(int x){
        this.val = x;
//        this.next = null;
    }
}

public class PrintPublicLinkedListSection {

    public static void printPublicLinkedListSection(Node head1, Node head2){

        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                head1 = head1.next;
            } else if (head1.val > head2.val){
                head2 = head2.next;
            } else {
                System.out.print(head1.val + "  ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);

        Node l2 = new Node(2);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        l2.next.next.next = new Node(5);

        printPublicLinkedListSection(l1, l2);

    }

}
