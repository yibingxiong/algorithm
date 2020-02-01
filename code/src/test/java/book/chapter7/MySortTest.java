package book.chapter7;

import org.junit.Test;

public class MySortTest {
    static void printArr(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "   ");
        }
        System.out.println();
    }

    @Test
    public void testInsertSort() {
        Integer[] arr = {1, 3, 4, 1, 5, 8, 0, 5, 9};
        MySort<Integer> mySort = new MySort<Integer>();
        mySort.insertSort(arr);
        MySortTest.printArr(arr);
    }

    @Test
    public void testShellSort() {
        Integer[] arr = {1, 3, 4, 1, 5, 8, 0, 5, 9};
        MySort<Integer> mySort = new MySort<Integer>();
        mySort.shellSort(arr);
        MySortTest.printArr(arr);
    }

    @Test
    public void testHeapSort() {
        Integer[] arr = {1, 3, 4, 1, 5, 8, 0, 5, 9};
        MySort<Integer> mySort = new MySort<Integer>();
        mySort.heapSort(arr);
        MySortTest.printArr(arr);
    }

    @Test
    public void testMergeSort() {
        Integer[] arr = {1, 3, 4, 1, 5, 8, 0, 5, 9};
        MySort<Integer> mySort = new MySort<Integer>();
        mySort.mergeSort(arr);
        MySortTest.printArr(arr);
    }

    @Test
    public void testQuickSort() {
        Integer[] arr = {1, 3, 4, 1, 5, 8, 0, 5, 9};
        MySort<Integer> mySort = new MySort<Integer>();
        mySort.quickSort(arr);
        MySortTest.printArr(arr);
    }
}
