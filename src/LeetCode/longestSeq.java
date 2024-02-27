package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class longestSeq {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int m = longestConsecutive(nums);
        System.out.println(m);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int maxCount = 0;

        for (int num : num_set) {
            int currentNum = num;
            int currentcount = 1;
            if (!num_set.contains(num - 1)) {
                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentcount++;
                }
            }
            maxCount = Math.max(currentcount,maxCount);
        }


        return maxCount;
    }
}
