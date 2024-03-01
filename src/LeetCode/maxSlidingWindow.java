package LeetCode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class maxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,2,1,3,6,7};
        int k = 3;
        int[] max = maxSlidingWindow(nums, k);
        for (int i : max) {
            System.out.print(i);
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});

            Iterator<int[]> iterator = pq.iterator();
            while (iterator.hasNext()) {
                int[] element = iterator.next();
                System.out.println("(" + element[0] + ", " + element[1] + ")");
            }
            System.out.println();
        }

        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});

            Iterator<int[]> iterator = pq.iterator();
            while (iterator.hasNext()) {
                int[] element = iterator.next();
                System.out.println("(" + element[0] + ", " + element[1] + ")");
            }

            System.out.println(pq.peek()[1]);

            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            Iterator<int[]> iterator2 = pq.iterator();
            while (iterator2.hasNext()) {
                int[] element = iterator2.next();
                System.out.println("(" + element[0] + ", " + element[1] + ")");
            }

            ans[i - k + 1] = pq.peek()[0];

            System.out.println();
        }
        return ans;
    }


}
