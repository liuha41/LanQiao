package LeetCode;

import java.util.*;

public class groupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = GroupAnagrams(strs);

        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s);
            }
            System.out.println();
        }


    }
    public static List<List<String>> GroupAnagrams(String[] strs) {
        Map<String,List<String>> Map = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            List<String> list = Map.getOrDefault(s, new ArrayList<String>());
            list.add(strs[i]);
            Map.put(s,list);
        }
        return new ArrayList<List<String>>(Map.values());
    }
}
