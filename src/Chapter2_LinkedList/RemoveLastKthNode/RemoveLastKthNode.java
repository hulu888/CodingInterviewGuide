package Chapter2_LinkedList.RemoveLastKthNode;

/**
 * 【题目】
 *      分别实现两个函数，一个可以删除单链表中倒数第K个几点，另一个可以删除双链表中倒数第K个节点
 *
 * 【要求】
 *      如果链表长度为N，时间复杂度达到O(N),额外空间复杂度O(1)
 */


class Node{
    int val;
    Node next;
    Node (int x){
        this.val = x;
        this.next = null;
    }
}

class DoubleNode{
    int val;
    DoubleNode next;
    DoubleNode pre;
    DoubleNode (int x){
        this.val = x;
    }
}


public class RemoveLastKthNode {

    public static Node removeSingleListLastKthNode(Node head, int kth){
        if (head == null || kth < 1){
            return head;
        }
        Node cur = head;
        while (cur != null){
            kth--;
            cur = cur.next;
        }
        if (kth == 0){
            // 倒数第k个节点就是头节点
            return head.next;
        }
        if (kth > 0){
            // 倒数第k个节点不存在
            return null;
        }
        if (kth < 0){
            cur = head;
            while (kth != 0){
                cur = cur.next;
                kth++;
            }
            cur.next = cur.next.next;

        }
        return head;
    }

    public static DoubleNode removeDoubleListLastKthNode(DoubleNode head, int kth){
        if (head == null || kth < 1){
            return head;
        }
        DoubleNode cur = head;
        while (cur != null){
            kth--;
            cur = cur.next;
        }
        if (kth == 0){
            head = head.next;
            head.pre = null;
        }
        if (kth > 0){
            return null;
        }
        if (kth < 0){
            cur = head;
            while (kth != 0){
                cur = cur.next;
                kth++;
            }
            DoubleNode newNode = cur.next.next;
            cur.next = newNode;
            if (newNode != null){
                newNode.pre = cur;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }

}
















