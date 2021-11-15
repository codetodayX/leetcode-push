package cn.codetoday.constructmaximumbinarytree;

/**
 * @author:codetoday
 * @date:2021-11-15 9:18
*/
public class ConstructMaximumBinaryTree {

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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        public TreeNode build(int[] nums, int start, int end) {
            int max = nums[start];
            int maxIndex = start;
            for (int i = start; i <= end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            TreeNode root = new TreeNode(max);
            TreeNode left = null;
            TreeNode right = null;
            if (maxIndex - 1 >= start) {
                left = build(nums, start, maxIndex - 1);
            }
            if (maxIndex + 1 <= end) {
                right = build(nums, maxIndex + 1, end);
            }
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
