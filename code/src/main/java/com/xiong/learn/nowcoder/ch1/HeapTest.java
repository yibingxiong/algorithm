package com.xiong.learn.nowcoder.ch1;

public class HeapTest {
    private int[] data;
    private int size;


    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public HeapTest() {
        this.data = new int[100];
        this.size = 0;
    }

    public void heapInsert(int x) {
        data[size] = x;
        int j = size;
        while ((j - 1) / 2 >= 0 && x > data[(j - 1) / 2]) {
            swap(data, j, (j-1)/2);
            j = (j - 1) / 2;
        }
        size++;
    }

    public void heapify(int i) {
        int l  =  2 * i+1;
        int r = 2 * i + 2;
        while (l < size) {
            int largestIndex = r < size && data[r] > data[l]? r:l;
            if (data[i] < data[largestIndex]) {
                swap(data, i, largestIndex);
                i = largestIndex;
                l  =  2 * i+1;
                r = 2 * i + 2;
            } else {
                break;
            }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]+"  ");
        }
    }


    public static void main(String[] args) {
        HeapTest heapTest = new HeapTest();
        heapTest.heapInsert(1);
        heapTest.heapInsert(8);
        heapTest.heapInsert(9);
        heapTest.heapInsert(0);
        heapTest.print();
    }
}
