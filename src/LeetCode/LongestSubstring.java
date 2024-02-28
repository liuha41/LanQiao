package LeetCode;

import java.util.HashSet;

public class LongestSubstring {

    public static void main(String[] args) {
        String s="abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s==null){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int left=0,right=0;
        int maxLength =right-left;
        while (right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength=Math.max(maxLength,right-left+1);
                right++;
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }

        }
        return maxLength;
    }
}
