public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void helper(int[][] image, int s, int e, int color, int newColor) {
        if (s < 0 || s >= image.length || e < 0 || e >= image.length || image[s][e] != color) {
            return;
        }

        image[s][e] = newColor;
        helper(image, s + 1, e, color, newColor);
        helper(image, s - 1, e, color, newColor);
        helper(image, s, e + 1, color, newColor);
        helper(image, s, e - 1, color, newColor);
        return;
    }
}
