package ru.zolov.tree;

import ru.zolov.util.TreeNode;

/**
 * /**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * You are given the root of a binary tree root. Invert the binary tree and return its root.
 *
 * @author skaiur
 */
public class InvertBinaryTreeSolution {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        var tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        // [1,2,3,4,5,6,7]
        var tree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)
                )
        );
        System.out.printf("Original: %s%n", tree);
        var invertedTree = invertTree(tree);
        System.out.printf("Inverted: %s",invertedTree);
    }
}
