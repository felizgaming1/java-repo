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

         
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    ans[i] = ans[j];

                }
            }
            if (ans[i] == 0) {
                ans[i] = ++flag;
            }

        }
        for (int i = 0; i < len; i++) {
            System.out.print(ans[i]);
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        String s1 ="abcadc";
        String s2="na4";
        solution(s);
        System.out.println();
        solution(s1);
        System.out.println();
        solution(s2);
    }
}
