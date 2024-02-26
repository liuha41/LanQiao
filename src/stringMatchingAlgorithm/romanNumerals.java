package stringMatchingAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class romanNumerals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            String s = scan.next();
            char[] chars = s.toCharArray();
            char last = chars[chars.length - 1];
            for (int j = chars.length - 1; j >= 0; j--) {
                int num1 = map.get(last);
                int num2 = map.get(chars[j]);
                if (num2 < num1) {
                    sum -= num2;
                } else {
                    sum += num2;
                }
                last = chars[j];
            }
            System.out.println(sum);
        }
        scan.close();
    }

}