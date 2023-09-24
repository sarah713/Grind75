public class DiameterBT {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxD = new int[1];
        helper(root, maxD);
        return maxD[0];
    }

    public int helper(TreeNode root, int[] d) {
        if (root == null)
            return 0;
        int lh = helper(root.left, d);
        int rh = helper(root.left, d);
        d[0] = Math.max(d[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
