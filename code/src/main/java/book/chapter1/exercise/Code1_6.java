package book.chapter1.exercise;

public class Code1_6 {
    public void permute(String str) {
        char[] charArr = str.toCharArray();
        permute(charArr, 0, charArr.length - 1);
    }

    public void permute(char[] chars, int low, int high) {
        if (low == high) {
            System.out.println(new String(chars));
        } else {
            for (int i = low; i <= high; i++) {
                char temp = chars[low];
                chars[low] = chars[i];
                chars[i] = temp;
                permute(chars, low + 1, high);
                temp = chars[low];
                chars[low] = chars[i];
                chars[i] = temp;
            }
        }
    }

}
