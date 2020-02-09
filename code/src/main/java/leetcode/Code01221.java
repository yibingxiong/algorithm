package leetcode;

public class Code01221 {
    public int balancedStringSplit(String s) {
        int res = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                k++;
            }
            if (s.charAt(i) == 'R') {
                k--;
            }
            if (k == 0) {
                res++;
            }
        }
        return res;
    }
}
