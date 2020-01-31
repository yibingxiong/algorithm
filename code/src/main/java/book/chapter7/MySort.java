package book.chapter7;

public class MySort<T extends Comparable<? super T>> {

    // 插入排序
    public void insertSort(T[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            T tmp = arr[i];
            while (j > 0 && tmp.compareTo(arr[j - 1]) < 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }

    // 希尔排序
    public void shellSort(T[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = 0; i < arr.length; i++) {
                T tmp = arr[i];
                int j = i;
                while (j > 0 && tmp.compareTo(arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = tmp;
            }
        }
    }

    private static <T extends Comparable<? super T>> void percDown(T[] arr, int i, int n) {
        int child;
        T tmp;

        for (tmp = arr[i]; 2 * i + 1 < n; i = child) {
            child = 2 * i + 1;
            if (child != n - 1 && arr[child].compareTo(arr[child + 1]) < 0) {
                child++;
            }
            if (tmp.compareTo(arr[child]) < 0) {
                arr[i] = arr[child];
            } else {
                break;
            }
        }
        arr[i] = tmp;
    }

    // 堆排序
    public static <T extends Comparable<? super T>> void heapSort(T[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            percDown(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            T tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            percDown(arr, 0, i);
        }
    }
}
