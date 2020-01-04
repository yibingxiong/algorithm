package leetcode;

import java.util.ArrayDeque;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;

public class Code682_calPoints {

	public static int calPoints(String[] ops) {
		int point = 0;
		ArrayDeque<String> s = new ArrayDeque<>();

		for (String string : ops) {
			if (string.equals("+")) {
				String m1 = s.pop();
				String m2 = s.pop();
				int gg = Integer.valueOf(m1) + Integer.valueOf(m2);
				point+=gg;
				s.push(m2);
				s.push(m1);
				s.push(Integer.toString(gg));

			} else if (string.equals("D")) {
				int yy = 2 * Integer.valueOf(s.peek());
				point += yy;
				s.push(Integer.toString(yy));

			} else if (string.equals("C")) {
				int k = Integer.valueOf(s.pop());
				point-=k;
			} else {
				point += Integer.valueOf(string);
				s.push(string);
			}
		}
		return point;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] k = {"5","2","C","D","+"};
		
		System.out.println(calPoints(k));
	}

}
