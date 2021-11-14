package cn.codetoday.rightpoin;

/**
 * @author: codetoday
 * @date: 2021-11-14 9:26
 * leetcode - 116题
 */
public class RightPointer {
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


    class Solution {
        public Node connect(Node root) {
            //明确当前root节点要做什么，什么时候做
            //需要将当前节点的左子节点的next指向右子节点(如果左右子节点存在的话,排除叶子节点情况)
            //然后判断当前节点的next指针是否为null，如果不为null，则当前节点右子节点的next->当前节点的next的左子节点
            //采用前序遍历框架
            if (root == null) {
                return null;
            }
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
            }
            connect(root.left);
            connect(root.right);
            return root;
        }
    }
}
