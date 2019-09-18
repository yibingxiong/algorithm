package leetcode;

public class Code028_strStr {

	public static int strStr(String haystack, String needle) {
		if (needle.equals("")) {
			return 0;
		}
		int i = 0;
		int j = 0;
		char stC = needle.charAt(0);
		while(i <= haystack.length() - needle.length()) {
			if (haystack.charAt(i) == stC) {
				j = 0;
				while(j < needle.length()) {
					if (needle.charAt(j) != haystack.charAt(i+j)) {
						i++;
						break;
					}
					j++;
				}
				if (j == needle.length()) {
					return i;
				}
			} else {
				i++;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("aaaa", "b"));
	}

}
