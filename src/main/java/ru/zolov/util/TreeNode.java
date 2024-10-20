package ru.zolov.util;

/**
 * @author skaiur
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("TreeNode{");
        sb.append("val=").append(val);
        if (left != null) {
            sb.append(", left=").append(left);
        }
        if (right != null) {
            sb.append(", right=").append(right);

        }
        sb.append('}');

        return sb.toString();
    }
}
