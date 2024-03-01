package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {6, 7}, {15, 18}};
        int[][] merged = merge(intervals);

//        int[][]merged = new int[2][2];
        for (int[] ints : merged) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
                merged.add(interval);
            }
            else {
                int[] removed = merged.remove(merged.size() - 1);
                removed[1]=Math.max(interval[1],removed[1]);
                merged.add(removed);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
