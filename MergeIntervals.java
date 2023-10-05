import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        if (intervals.length == 0 || intervals == null) {
            return res.toArray(new int[0][]);
        }

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] row : intervals) {
            if (row[0] <= end) {
                end = Math.max(row[1], end);
            } else {
                res.add(new int[] { start, end });
                start = row[0];
                end = row[1];
            }
        }
        res.add(new int[] { start, end });
        return res.toArray(new int[0][]);
    }
}
