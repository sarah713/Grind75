import java.util.Arrays;

class TwoSum {
    public int[] twosum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[] { nums[left], nums[right] };
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }
}