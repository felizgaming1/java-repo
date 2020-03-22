import java.util.Scanner;

public class Stringincre {

    public static void solution(String s) {
        int flag = 0;
        int len = s.length();
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
           //if there is digit in the string
            if (Character.isDigit(s.charAt(i)) ) {
                System.out.println("ERROR");
                System.exit(0);
            }

           //for searching same char
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans[i] = ans[j];

                }
            }
            //for new char
            if (ans[i] == 0) {
                ans[i] = ++flag;
            }

        }
        for (int i = 0; i < len; i++) {
            System.out.print(ans[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter your String:");
        String s =sc.nextLine();
        solution(s);
    }
}
