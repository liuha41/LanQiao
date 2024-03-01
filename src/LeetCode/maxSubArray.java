package LeetCode;

public class maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(nums);
        System.out.println(max);
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        // 定义 dp 数组
        int[] dp = new int[n];
        // 初始状态
        dp[0] = nums[0];
        // 最大和
        int maxSum = nums[0];
        // 状态转移
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
