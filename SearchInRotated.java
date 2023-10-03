public class SearchInRotated {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? nums[0] : -1;
        }

        int lo = 0, hi = nums.length - 1;
        if (nums[0] < nums[nums.length - 1]) {
            lo = 0;
            hi = nums.length - 1;
        } else {
            int breakpt = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > nums[i + 1]) {
                    breakpt = i;
                    break;
                }
            }
            if (nums[breakpt] >= target && nums[0] <= target) {
                lo = 0;
                hi = breakpt;
            } else {
                lo = breakpt + 1;
                hi = nums.length - 1;
            }

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;

    }
}
