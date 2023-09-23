public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0, ele = 0;
        for (int i : nums) {
            if (count == 0) {
                count = 1;
                ele = i;
            } else if (i == ele) {
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }
}
