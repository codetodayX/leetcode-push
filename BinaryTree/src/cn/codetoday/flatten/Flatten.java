package cn.codetoday.flatten;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * @author: codetoday
 * @date: 2021-11-14 10:48
 */
public class Flatten {

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
        public void flatten(TreeNode root) {
            //采用后序遍历框架
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);
            if (root.left != null) {
                TreeNode temp = root.left;
                //找出左子树的右子树末端
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = root.left;
                //还需将左子节点置为null
                root.left = null;
            }
        }
    }
}
