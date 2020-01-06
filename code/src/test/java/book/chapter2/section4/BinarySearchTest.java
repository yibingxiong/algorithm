package book.chapter2.section4;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void testSearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1,3,4,5,6,7,8,9};

        Assert.assertEquals(binarySearch.search(arr, 4), 2);
        Assert.assertEquals(binarySearch.search(arr, 1), 0);
        Assert.assertEquals(binarySearch.search(arr, 9), arr.length-1);
        Assert.assertEquals(binarySearch.search(arr, 10), -1);
        Assert.assertEquals(binarySearch.search(arr, 0), -1);
        Assert.assertEquals(binarySearch.search(arr, 2), -1);
    }
}
