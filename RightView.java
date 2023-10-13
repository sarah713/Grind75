import java.util.ArrayList;
import java.util.List;

public class RightView {
    int maxLevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }

        if (level > maxLevel) {
            res.add(root.val);
            maxLevel = level;
        }
        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);
    }
}

class TreeNode {
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