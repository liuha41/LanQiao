package LeetCode;

import java.util.Arrays;

public class movingZero {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,12,67,899};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }


    }
}