public class TrappingRainWater {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        int water = 0;
        while (left <= right) {
            if (height[left] > height[right]) {
                if (height[left] < leftMax) {
                    water += leftMax - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                if (height[right] < rightMax) {
                    water += rightMax - height[right];
                }
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return water;
    }
}
