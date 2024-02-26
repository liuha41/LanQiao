package stringMatchingAlgorithm;

import java.util.Scanner;

public class stringProcessing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = processNumbers(input);
        String[] split = input.split(" +");
        for (String s : split) {
            if(s.charAt(0)>='a'&&s.charAt(0)<='z') {
                System.out.print((char)(s.charAt(0)-32));
                for (int i =1;i<s.length();i++){
                    System.out.print(s.charAt(i));
                }
                System.out.print(" ");
            }
            else {
                System.out.print(s+" ");
            }
        }

    }

    public static String processNumbers(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(i + 1);
            if((c1>='a'&&c1<='z'&&c2>='0'&&c2<='9')||(c2>='a'&&c2<='z'&&c1>='0'&&c1<='9')){
                String s1 = input.substring(i + 1);
                String s2 = input.substring(0, i + 1);
                input = s2+'_'+s1;
            }
        }
        return input;
    }

}
