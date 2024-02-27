package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeNumSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);

        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if(nums[i]+nums[l]+nums[r] <0)l++;
                else if (nums[i]+nums[l]+nums[r] >0) r--;
                else {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[l]);
                    ls.add(nums[r]);
                    list.add(ls);
                    while (l<r && nums[l]==nums[l+1])l++;
                    while (l<r && nums[r]==nums[r-1])r--;
                    l++;
                    r--;
                }

            }
        }
        return list;
    }
}
