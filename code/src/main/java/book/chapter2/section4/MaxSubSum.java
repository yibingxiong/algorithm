package book.chapter2.section4;

public class MaxSubSum {

    // 暴力算法O(n^3)
    public int maxSubSum1(int[] arr) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int nowSum = 0;
                for (int k = i; k <= j; k++) {
                    nowSum += arr[k];
                }
                if (sum < nowSum) {
                    sum = nowSum;
                }
            }
        }
        return sum;
    }

    // 暴力算法优化O(n^2)
    public int maxSubSum2(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int thisSum = 0;
            for (int j = i; j < arr.length; j++) {
                thisSum += arr[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    // 分治算法O(nlogn)
    public int maxSubSum3(int[] arr) {
        return this.maxSubSum3(arr, 0, arr.length - 1);
    }

    public int maxSubSum3(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left] > 0 ? arr[left] : 0;
        }

        int mid = left + (right - left) / 2;

        int leftMaxSum = maxSubSum3(arr, left, mid);
        int rightMaxSum = maxSubSum3(arr, mid + 1, right);

        int leftMaxSumIncludeLast = Integer.MIN_VALUE;
        int leftSumIncludeLast = 0;
        for (int i = left; i >= 0; i--) {
            leftSumIncludeLast += arr[i];
            if (leftSumIncludeLast > leftMaxSumIncludeLast) {
                leftMaxSumIncludeLast = leftSumIncludeLast;
            }
        }

        int rightMaxSumIncludeFirst = Integer.MIN_VALUE;
        int rightSumIncludeFirst = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightSumIncludeFirst += arr[i];
            if (rightSumIncludeFirst > rightMaxSumIncludeFirst) {
                rightMaxSumIncludeFirst = rightSumIncludeFirst;
            }
        }

        return Math.max(leftMaxSum, Math.max(rightMaxSum, leftMaxSumIncludeLast + rightMaxSumIncludeFirst));
    }

    // 线性时间的算法
    public int maxSubSum4(int[] arr) {
        int maxSum = 0;
        int thisSum = 0;

        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
