package LeetCode;

public class maxWater {
    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        maxArea(height);


    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length-1;
        while (i<j){
            maxArea = height[i] < height[j] ?
                    Math.max(maxArea, (j - i) * height[i++]):
                    Math.max(maxArea, (j - i) * height[j--]);
        }

        return maxArea;
    }
}
