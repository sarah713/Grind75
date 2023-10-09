public class SortColors {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = nums.length - 1;
        while (one <= two) {
            if (nums[one] == 0) {
                int tmp = nums[zero];
                nums[zero] = nums[one];
                nums[one] = tmp;
                one++;
                zero++;
            } else if (nums[one] == 2) {
                int tmp = nums[two];
                nums[two] = nums[one];
                nums[one] = tmp;
                two--;
            } else {
                one++;
            }
        }
    }
}
