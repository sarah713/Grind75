import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int total = 0, rotten = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotten++;
                    q.offer(new int[] { i, j });
                } else if (grid[i][j] > 0) {
                    total++;
                }
            }
        }

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        int minutes = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            rotten += size;
            for (int j = 0; j < size; j++) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + dx[i];
                    int y = cur[0] + dy[i];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0
                            || grid[x][y] == 2) {
                        continue;
                    } else {
                        grid[x][y] = 2;
                        q.offer(new int[] { x, y });
                    }
                }
            }
            if (q.size() != 0) {
                minutes++;
            }
        }
        return total == rotten ? minutes : -1;
    }
}
