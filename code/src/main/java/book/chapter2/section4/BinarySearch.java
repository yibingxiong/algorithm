package book.chapter2.section4;

public class BinarySearch {
    public int search(int[] arr, int n) {
        int low = 0;
        int high = arr.length-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (n < arr[mid]) {
                high = mid - 1;
            } else if (n > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
