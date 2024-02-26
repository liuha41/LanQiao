package stringMatchingAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class deleteCahr {

    static StringBuffer addStr;

    static String str="";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        int num = sc.nextInt();

        int m = str.length() - num;
        addStr = new StringBuffer();
        deleteChar(str.toCharArray(),m,0);

        System.out.println(str);

    }

    public static void deleteChar(char[] ch, int m, int startIndex) {
        if (addStr.length() == m) {
            if(str.compareTo(addStr.toString())>0){
                str = addStr.toString();
            }
            return;
        }
        for (int i = startIndex; i < ch.length; i++) {
            addStr.append(ch[i]);
            deleteChar(ch,m,i+1);
            addStr=addStr.deleteCharAt(addStr.length() - 1);
        }

    }
}
