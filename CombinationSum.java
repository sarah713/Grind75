import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    public void helper(int[] candidates, int idx, int target, List<Integer> cur, List<List<Integer>> res) {
        if (idx == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        if (candidates[idx] <= target) {
            cur.add(candidates[idx]);
            helper(candidates, idx + 1, target - candidates[idx], cur, res);
            cur.remove(cur.size() - 1);
        }
        helper(candidates, idx + 1, target, cur, res);

    }

}
