package cn.codetoday;

/**
 * @author: codetoday
 * @date: 2021-11-13 10:18
 * 翻转二叉树
 */
public class OverTurnBinaryTree {
    public static void overTurn(Node root) {
        if (root == null) {
            return;
        }
        //明确root应该做什么
        Node temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        //明确在什么时候做
        overTurn(root.getLeft());
        overTurn(root.getRight());

    }
}
