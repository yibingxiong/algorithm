package com.xiong.nowcoder;

import java.util.Arrays;

public class NC63 {
    public class Solution {
        public boolean isContinuous(int[] numbers) {
            if (numbers == null || numbers.length != 5) {
                return false;
            }
            Arrays.sort(numbers);

            int gap = 0;
            int zeroCount = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) {
                    zeroCount++;
                } else {
                    break;
                }
            }
            int start = zeroCount;
            for (int i = start + 1; i < 5; i++) {
                if (numbers[i] == numbers[i - 1]) {
                    return false;
                }
                gap = gap + (numbers[i] - numbers[i - 1]) - 1;
            }
            if (gap > zeroCount) {
                return false;
            }
            return true;
        }

    }
}
