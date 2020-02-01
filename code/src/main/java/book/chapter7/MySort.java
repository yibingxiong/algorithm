package book.chapter7;

public class MySort<T extends Comparable<? super T>> {

    private static final int CUTOFF = 17;

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

    private void insertSort(T[] arr, int left, int right) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = left + 1; i <= right; i++) {
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


    private T median3(T[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (arr[mid].compareTo(arr[left]) < 0) {
            T tmp = arr[left];
            arr[left] = arr[mid];
            arr[mid] = tmp;
        }
        if (arr[right].compareTo(arr[left]) < 0) {
            T tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }

        if (arr[right].compareTo(arr[mid]) < 0) {
            T tmp = arr[mid];
            arr[mid] = arr[right];
            arr[right] = tmp;
        }

        T tmp = arr[mid];
        arr[mid] = arr[right - 1];
        arr[right - 1] = tmp;
        return arr[right - 1];
    }

    private void quickSort(T[] arr, int left, int right) {
        if (left + CUTOFF <= right) {
            System.out.println("right" + right);
            T pivot = median3(arr, left, right);
            int i = left;
            int j = right - 1;
            for (; ; ) {
                while (i < right && arr[i++].compareTo(pivot) < 0) {

                }
                while (j > left && arr[--j].compareTo(pivot) > 0) {

                }
                if (i < j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } else {
                    break;
                }
            }

            T tmp = arr[i];
            arr[i] = arr[right - 1];
            arr[right - 1] = tmp;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        } else {
            insertSort(arr, left, right);
        }

    }

    public void quickSort(T[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

}
