package book.chapter1.section1;

import org.junit.Assert;
import org.junit.Test;

public class KMaxTest {
    @Test
    public void testGetKmax() {

        KMax kMax = new KMax();

        int[] arr = {0, 9, 3, 8, 1, 2, 2, 3, 3, 4, 5};
        for (int i = 1; i < 100; i++) {
            Assert.assertEquals(9L, kMax.getKmax(arr, 1).longValue());
            Assert.assertEquals(8L, kMax.getKmax(arr, 2).longValue());
            Assert.assertEquals(0L, kMax.getKmax(arr, arr.length).longValue());
        }
    }

    @Test
    public void testGetKmax2() {

        KMax kMax = new KMax();

        int[] arr = {0, 9, 3, 8, 1, 2, 2, 3, 3, 4, 5};
        for (int i = 1; i < 100; i++) {
            Assert.assertEquals(9L, kMax.getKmax2(arr, 1).longValue());
            Assert.assertEquals(8L, kMax.getKmax2(arr, 2).longValue());
            Assert.assertEquals(0L, kMax.getKmax2(arr, arr.length).longValue());
        }
    }

}
