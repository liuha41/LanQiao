package LeetCode;

public class rotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }
}
