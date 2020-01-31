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
    public <T extends Comparable<? super T>> void heapSort(T[] arr) {
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

    private void mergeSort(T[] arr, T[] tmpArray, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, tmpArray, left, mid);
            mergeSort(arr, tmpArray, mid + 1, right);

            merge(arr, tmpArray, left, mid + 1, right);
        }
    }

    public void mergeSort(T[] arr) {
        T[] tmpArray = (T[]) new Comparable[arr.length];
        mergeSort(arr, tmpArray, 0, arr.length - 1);
    }

    private void merge(T[] arr, T[] tmpArray, int leftStart, int rightStart, int rightEnd) {
        int leftEnd = rightStart - 1;
        int tmpPos = leftStart;
        int numElements = rightEnd - leftStart + 1;

        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart].compareTo(arr[rightStart]) <= 0) {
                tmpArray[tmpPos++] = arr[leftStart++];
            } else {
                tmpArray[tmpPos++] = arr[rightStart++];
            }
        }

        while (leftStart <= leftEnd) {
            tmpArray[tmpPos++] = arr[leftStart++];
        }
        while (rightStart <= rightEnd) {
            tmpArray[tmpPos++] = arr[rightStart++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            arr[rightEnd] = tmpArray[rightEnd];
        }
    }
}
