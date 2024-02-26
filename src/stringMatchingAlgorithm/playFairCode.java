package stringMatchingAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class playFairCode {
    private static char[][] map = new char[5][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pair = sc.nextLine();
        String code = sc.nextLine();

        char[] pairCharArray = pair.toCharArray();
        init(pairCharArray);
        String res = "";
        char[] cs = code.toCharArray();
        for (int k = 0; k < code.length(); k += 2) {
            //最后只剩一个字符，直接输出
            if (k == code.length() - 1) {
                res += cs[k];
                continue;
            }
            //一对相同字母，直接输出
            if (cs[k] == cs[k + 1]) {
                res += cs[k] + "" + cs[k + 1];
                continue;
            }

            //找到两个字符的行号和列号、
            int r1 = -1, c1 = -1, r2 = -1, c2 = -1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] == cs[k]) {
                        r1 = i;
                        c1 = j;
                    }
                    if (map[i][j] == cs[k + 1]) {
                        r2 = i;
                        c2 = j;
                    }
                }
            }
            //字母不在矩阵中
            if (r1 < 0 || r2 < 0) {
                res += cs[k] + "" + cs[k + 1];
            }
            //同行或同列，变换先后位置，输出
            else if (r1 == r2 || c1 == c2) {
                res += cs[k + 1] + "" + cs[k];
            }
            //正常情况
            else {
                res += map[r1][c2] + "" + map[r2][c1];
            }
        }
        System.out.println(res);
    }

    public static void init(char[] pairCharArray) {
        char flag = 'a';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i * 5 + j) < pairCharArray.length) {
                    map[i][j] = pairCharArray[i * 5 + j];
                } else {
                    while (containsCharacter(pairCharArray, flag)) flag++;
                    map[i][j] = flag++;
                }
            }
        }

    }

    public static boolean containsCharacter(char[] charArray, char targetChar) {
        for (char c : charArray) {
            if (c == targetChar) {
                return true;
            }
        }
        return false;
    }
}
