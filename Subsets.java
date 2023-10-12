import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void helper(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // include
        cur.add(nums[idx]);
        helper(nums, idx + 1, cur, res);

        // exclude
        cur.remove(cur.size() - 1);
        helper(nums, idx + 1, cur, res);
    }
}
