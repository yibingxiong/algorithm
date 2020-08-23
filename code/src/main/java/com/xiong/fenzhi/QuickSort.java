package com.xiong.fenzhi;

/**
 * 快速排序
 */
public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        int m = arr[i];
        arr[i] = arr[j];
        arr[j] = m;
    }

    public static void sort(int[] arr, int i, int j) {
        if (i < j) {
            int pos = partition(arr, i, j);
            sort(arr, i, pos - 1);
            sort(arr, pos + 1, j);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];//先定义区间数组第一个元素为主元
        int i = left;   //定义最低的索引low是first+1。比主元大一位
        int j = right;     //定义最高的索引high是last
        while (i < j) {   //当low小于high的位置时，执行以下循环
            while (arr[j] > pivot && i < j) {//当high的索引上的值比主元大时，且索引大于low时
                j--;                      //寻找比主元小的值的位置索引
            }
            while (arr[i] <= pivot && i < j) {//当low的索引上的值比主元小时，索引小于high时
                i++;                       //寻找比主元大的值的位置索引。
            }
            swap(arr, i, j);
        }

        arr[left] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void sort2(int[] arr, int i, int j) {
        if (i < j) {
            int p = partition2(arr, i, j);
            sort2(arr, i, p - 1);
            sort2(arr, p + 1, j);
        }
    }

    public static int partition2(int[] arr, int low, int high) {
        int x = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && arr[j] > x) {
                j--;
            }
            while (i < j && arr[i] <= x) {
                i++;
            }
            swap(arr, i, j);
        }
        arr[low] = arr[j];
        arr[j] = x;
        return j;
    }


    public static void sort3(int[] arr, int i, int j) {
        if (i < j) {
            int pos = partition3(arr, i, j);
            sort3(arr, i, pos - 1);
            sort3(arr, pos + 1, j);
        }
    }

    private static int partition3(int[] arr, int i, int j) {
        int x = arr[i];
        int l = i;
        int r = j;

        while (l < r) {
            while (arr[r] > x && r > l) {
                r--;
            }
            while (arr[l] <= x && r > l) {
                l++;
            }
            swap(arr, l, r);
        }
        arr[i] = arr[r];
        arr[r] = x;
        return r;
    }


    public static void sort4(int[] arr, int i, int j) {
        if (i < j) {
            int pos = partition4(arr, i, j);
            sort4(arr, i, pos - 1);
            sort4(arr, pos + 1, j);
        }
    }

    private static int partition4(int[] arr, int i, int j) {
        int x = arr[i];
        int p = i;
        int q = j;
        while (p < q) {
            while (arr[q] >= x && p < q) {
                q--;
            }
            while (arr[p] < x && p < q) {
                p++;
            }

            swap(arr, p, q);
        }
        arr[i] = arr[p];
        arr[p] = x;
        return p;
    }


    public static void sort5(int[] arr, int i, int j) {
        if (i < j) {
            int povit = partition5(arr, i, j);
            sort5(arr, i, povit - 1);
            sort5(arr, povit + 1, j);
        }
    }

    private static int partition5(int[] arr, int i, int j) {
        int l = i;
        int r = j;
        int x = arr[i];

        while (l < r) {
            while (arr[r] >= x && l < r) {
                r--;
            }
            while (arr[l] < x && l < r) {
                l++;
            }
            swap(arr, l, r);
        }

        arr[i] = arr[r];
        arr[r] = x;
        return r;
    }


    public static void sort6(int arr[], int i, int j) {
        if (i < j) {
            int index = partition6(arr, i, j);
            sort6(arr, i, index - 1);
            sort6(arr, index+1, j);
        }
    }

    private static int partition6(int[] arr, int i, int j) {
        int x = arr[i];
        int tIndex = 0;
        int left = i;
        int right = j;
        while (left < right) {
            while (arr[right] >= x && left < right) {
                right--;
            }
            while (arr[left] < x && left < right) {
                left++;
            }

            swap(arr, left, right);
        }

        arr[left] = arr[right];
        arr[right] = x;
        return right;
    }

    public static void sort7(int[] arr, int i, int j) {
        if (i < j) {
            int pos = partition7(arr, i, j);
            sort7(arr, i, pos - 1);
            sort7(arr, pos+1, j);
        }
    }

    public static int partition7(int[] arr, int i, int j) {
        int x = arr[i];
        int p = i;
        int q = j;

        while (p < q) {
            while (arr[q] >=x && p < q) {
                q--;
            }
            while (arr[p] < x && p < q) {
                p++;
            }
            swap(arr, p, q);
        }
        arr[i] = arr[q];
        arr[q] = x;
        return q;
    }

    public static void quickSort(int[] data, int i, int j) {
        if (i < j) {
            int pos = partition8(data, i, j);
            quickSort(data, i, pos-1);
            quickSort(data, pos+ 1, j);
        }
    }

    private static int partition8(int[] data, int i, int j) {
        int index = (int)(Math.random() * (j - i + 1)+i);
        int x = data[index];
        int p =i;
        int q = j;

        while (p < q) {
            while (q > p && data[q] >= x) {
                q--;
            }
            while (q > p && data[p] < x) {
                p++;
            }
            swap(data, p, q);
        }
        data[index] = data[q];
        data[q] = x;
        return q;
    }

    public static void main(String[] args) {
        int arr2[] = {1, 6, 5, 5, 4, 2, 3, 5, 7};

        quickSort(arr2, 0, arr2.length - 1);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + ", ");
        }
    }
}
