package book.chapter1.section1;

public class KMax {
    public Integer getKmax(int[] arr, int k) {
        if (k > arr.length) {
            return null;
        }
        if (arr.length != 0) {
            for (int i = arr.length - 1; i > 0; i--) {
                for (int j = 1; j <= i; j++) {
                    if (arr[j - 1] < arr[j]) {
                        int t = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = t;
                    }
                }
            }
        }

        return arr[k - 1];
    }

    public Integer getKmax2(int[] arr, int k) {
        if (k > arr.length) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] < arr[j]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                }
            }
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > arr[k - 1]) {
                int m = arr[k - 1];
                arr[k - 1] = arr[i];
                arr[i] = m;
                for (int j = k - 1; j > 0; j--) {
                    if (arr[j] > arr[j - 1]) {
                        int t = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = t;
                    } else {
                        break;
                    }
                }
            }
        }

        return arr[k - 1];
    }
}
