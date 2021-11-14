package cn.codetoday.OverTurn;

/**
 * @author: codetoday
 * @date: 2021-11-14 9:28
 * leetcode - 226题
 */
public class OverTurn {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            //明确root应该做什么
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            //明确在什么时候做
            invertTree(root.left);
            invertTree(root.right);

            return root;
        }
    }
}
