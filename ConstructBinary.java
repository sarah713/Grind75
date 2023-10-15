import java.util.Arrays;

class ConstructBinary {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int leftIdx = 0;
        while (leftIdx < inorder.length && inorder[leftIdx] != root.val) {
            leftIdx++;
        }
        TreeNode left = buildTree(Arrays.copyOfRange(preorder, 1, leftIdx + 1),
                Arrays.copyOfRange(inorder, 0, leftIdx));
        TreeNode right = buildTree(Arrays.copyOfRange(preorder, leftIdx + 1, preorder.length),
                Arrays.copyOfRange(inorder, leftIdx + 1, inorder.length));

        if (left != null) {
            root.left = left;
        }
        if (right != null) {
            root.right = right;
        }
        return root;
    }
}