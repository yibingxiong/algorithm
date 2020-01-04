package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Code496_nextGreaterElement {

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] res = new int[nums1.length];
		for (int i =0; i<nums2.length-1;i++) {
			for (int j = i+1; j < nums2.length;j++) {
				if (nums2[j] > nums2[i]) {
					map.put(nums2[i], nums2[j]);
					break;
				}
			}
		}
		
		System.out.println(map);
		
		for (int i =0; i< nums1.length; i++) {
			res[i] = map.get(nums1[i])==null?-1:map.get(nums1[i]);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,1,2};
		int[] b = {1,3,4,2};
		
		System.out.println(Arrays.toString(nextGreaterElement(a, b)));
	}

}
