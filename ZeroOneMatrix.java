import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0][0];
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        int len = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + cur[0];
                int y = dy[i] + cur[1];
                if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y] > mat[cur[0]][cur[1]] + 1) {
                    q.offer(new int[] { x, y });
                    mat[x][y] = mat[cur[0]][cur[1]] + 1;
                }
            }
        }
        return mat;
    }
}
