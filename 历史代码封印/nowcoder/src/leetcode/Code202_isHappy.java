package leetcode;

import java.util.HashSet;

import org.omg.CORBA.SystemException;

public class Code202_isHappy {

	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<>();

		int m = calPow(n);
		set.add(m);
		if (m == 1) {
			return true;
		}

		while (true) {
			m = calPow(m);
			if (m == 1) {
				return true;
			}
			if (set.contains(m)) {
				return false;
			}
			set.add(m);
		}
	}

	public static int calPow(int x) {
		int pre = 0;
		int res = 0;
		int k = 0;
		if (x < 10) {
			return (int) Math.pow(x, 2);
		}
		while (Math.pow(10, k) <= x) {
			k++;
		}
		k--;
		while (k > 0) {
			int m = (int) Math.floor(((x - pre) / Math.pow(10, k--)));
			pre += m * Math.pow(10, k + 1);
			res += Math.pow(m, 2);
		}
		res += Math.pow(x - pre, 2);

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(19));
//		System.out.println(calPow(100));
	}

}
