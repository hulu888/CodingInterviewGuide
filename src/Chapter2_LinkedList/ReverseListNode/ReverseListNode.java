package Chapter2_LinkedList.ReverseListNode;

import com.sun.jmx.snmp.SnmpGauge;

/**
 反转单向和双向链表

 【题目】
    分别实现反转单向链表和反转双向链表的函数

 【要求】
    如果链表长度为 N ，时间复杂度要求为 O(N),额外空间复杂度要求为 O(1)
 */

class SingleNode{
    int val;
    SingleNode next;
    SingleNode(int x){
        this.val = x;
    }
}

class DoubleNode{
    int val;
    DoubleNode next;
    DoubleNode pre;
    DoubleNode(int x){
        this.val = x;
    }
}

public class ReverseListNode {
    // 反转单向链表
    public SingleNode reverseSingleListNode(SingleNode head){
        SingleNode pre = null;
        SingleNode last = null;
        while (head != null){
            pre = head.next;
            head.next = last;
            last = head;
            head = pre;
        }
        return last;
    }

    // 反转双向链表
    public DoubleNode reverseDoubleListNode(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode last = null;

        while (head != null){
            pre = head.next;
            head.next = last;
            head.pre = last;
            last = head;
            head = pre;
        }
        return last;
    }
}




























