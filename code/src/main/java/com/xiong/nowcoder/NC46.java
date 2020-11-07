package com.xiong.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class NC46 {
    public static class Solution {
        private ArrayList<ArrayList<Integer>> res = new ArrayList();

        public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
            if (num == null || num.length == 0 || target <= 0) {
                return res;
            }
            Arrays.sort(num);
            ArrayList<Integer> one = new ArrayList();
            com(num, target, 0, num.length - 1, one);
            return res;
        }

        private void com(int[] num, int target, int start, int end, ArrayList<Integer> one) {
            if (target == 0) {
                res.add(new ArrayList(one));
                return;
            }
            for (int i = start; i <= end; i++) {
                if (i > start && num[i] == num[i - 1]) { // 去掉重复的组合
                    continue;
                }
                if (num[i] <= target) {
                    one.add(num[i]); // i 选择i的情况
                    com(num, target - num[i], i + 1, num.length - 1, one);
                    one.remove(one.size() - 1); // 不选择i
                } else {
                    return;
                }

            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> arrayLists = solution.combinationSum2(new int[]{1, 2}, 4);
        System.out.println(arrayLists);

    }
}
