package Chapter3_Tree.Traversal_1;

import java.util.Stack;

/**
 分别用递归和非递归的方式实现二叉树限序、中序、后序遍历


 */

class Node{
    int val;
    Node left;
    Node right;
    Node(int x){
        this.val = x;
    }
}



public class Traversal {
    // 递归先序遍历
    public void preOrderRecursive(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.val + " ");
        preOrderUnRecursive(head.left);
        preOrderUnRecursive(head.right);
    }

    // 递归中序遍历
    public void inOrderRecursive(Node head){
        if (head == null){
            return;
        }
        inOrderRecursive(head.left);
        System.out.println(head.val + " ");
        inOrderRecursive(head.right);
    }

    // 递归后序遍历
    public void posOrderRecursive(Node head){
        if (head == null){
            return;
        }
        posOrderUnRecursive(head.left);
        posOrderUnRecursive(head.right);
        System.out.println(head.val + " ");
    }

    // 非递归先序遍历
    /*
    1. 申请一个新栈，记为stack，然后将头节点压入stack中；
    2. 从stack中弹出栈顶节点，记为cur，然后打印cur节点的值，再将节点cur的右孩子（不为空的话）先压入stack中，最后将cur的左孩子
        （不为空的话）压入stack中；
    3. 不断重复步骤2，直到stack为空，全部结束
     */
    public void preOrderUnRecursive(Node head){
        if (head == null){
            return;
        }
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            while (stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.val + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    // 非递归中序遍历
    /*
     1. 申请一个新的栈，记为stack。初始时，令变量cur= = head；
     2. 先把cur节点压入栈中，对以cur节点为头的整棵子树来说，依次把左边界压入栈中，即，不停的令cur = cur.left，然后重复操作2；
     3. 不断重复2，知道发现cur为空，此时从stack中弹出一个节点，记为node，打印node的值，并让cur = node.right,然后再重复2；
     4. 当stack为空切cur为空时，停止过程。
     *
     */
    public void inOrderUnRecursive(Node head){
        if (head == null){
            return;
        }
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    // 非递归后序遍历
    /*
    1. 申请一个栈，记为s1，然后将头结点压入s1;
    2. 从s1中弹出的节点记为cur，然后依次将cur的左孩子和右孩子压入s1中；
    3. 在整个过程中，每一个从s1中弹出的节点都放入s2中；
    4. 重复2/3步骤，直到s1为空，过程停止；
    5. 从s2中依次弹出节点并打印，打印的顺序就是后序遍历的顺序。
     */
    public void posOrderUnRecursive(Node head){
        if (head == null){
            return;
        }
        if (head != null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop().val + " ");
            }
        }
    }


}
























