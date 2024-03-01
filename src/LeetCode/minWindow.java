package LeetCode;

public class minWindow {


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);

        System.out.println(ans);

    }

    public static String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i)]++;
        }
        int left = 0, right = 0, ansL = 0, ansR = 0, ans = Integer.MAX_VALUE, cntT = t.length();
        while (right < s.length()) {
            if (cnt[s.charAt(right++)]-- > 0) cntT--;
            while (cntT == 0) {
                if (right - left < ans) {
                    ansL = left;
                    ansR = right;
                    ans = right - left;
                }
                if(cnt[s.charAt(left++)]++ ==0) cntT++;
            }
        }
        return  ans == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
    }

}
