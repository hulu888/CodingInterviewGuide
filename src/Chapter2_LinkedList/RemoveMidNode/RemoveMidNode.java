package Chapter2_LinkedList.RemoveMidNode;

/**
 删除链表的中间节点和a/b处的节点

 【题目】
    给定链表的头结点head，实现删除链表的中间节点的函数
 【例子】
    空   不删除任何节点
    1->2    删除节点1；
    1->2->3     删除节点2
    1->2->3->4      删除节点2
    1->2->3->4->5   删除节点3

 【进阶】
    给定链表头节点head、整数 a 和 b ，实现删除位于 a/b 处节点的函数。
 【例子】
    链表：1->2->3->4->5，假设 a/b 的值为 r
    如果 r 等于 0，不删除任何节点
    如果 r 在区间(0, 1/5]，删除节点 1
    如果 r 在区间(1/5, 2/5]，删除节点 2
    如果 r 在区间(2/5, 3/5]，删除节点 3
    如果 r 在区间(3/5, 4/5]，删除节点 4
    如果 r 在区间(4/5, 1]，删除节点 5
    如果 r 大于 1，不删除任何节点


 */

class Node{
    int val;
    Node next;
    Node(int x){
        this.val = x;
    }
}


public class RemoveMidNode{
    // 移除中间节点
    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head.next.next;
        Node last = head;
        while (last.next != null || pre.next.next != null) {
            last = last.next;
            pre = pre.next.next;
        }
        last.next = last.next.next;
        return head;
    }

    // 进阶：删除位于 a/b 处节点
    public Node removeNodeByRatio(Node head, int a, int b){
        if (head == null || a < 1 || a > b){
            return head;
        }
        int len = 0;
        Node cur = head;
        int pos = 0;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        pos = (int) Math.ceil(((double) (a * len)) / (double) b);
        if (len == 1){
            return head.next;
        }
        if (len > 1){
            cur = head;
            while (pos != 1){
                pos--;
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    public static void main(String[] args) {

    }
}




















