package book.chapter2.section4;

import org.junit.Test;

public class MaxSubSumTest {
    private int[] arr = {1,2,3,-14,-1,5,1,-3};
    @Test
    public void testMaxSubSum1() {
       MaxSubSum maxSubSum = new MaxSubSum();
        System.out.println(maxSubSum.maxSubSum1(arr));
    }
    @Test
    public void testMaxSubSum2() {
        MaxSubSum maxSubSum = new MaxSubSum();
        System.out.println(maxSubSum.maxSubSum2(arr));
    }

    @Test
    public void testMaxSubSum3() {
        MaxSubSum maxSubSum = new MaxSubSum();
        System.out.println(maxSubSum.maxSubSum3(arr));
    }

    @Test
    public void testMaxSubSum4() {
        MaxSubSum maxSubSum = new MaxSubSum();
        System.out.println(maxSubSum.maxSubSum4(arr));
    }
}
