package com.example.myalgorithm.sort;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {

        if (l < r) {
            final int[] p = parttion(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);

        }
    }

    /*public static int[] patition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }*/

    public static int[] parttion(int[] arr, int l, int r){
        int less = l-1;
        int more = r;
        while (l<more){
            if(arr[l]<arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l]>arr[r]){
                swap(arr,--more,l);
            }else {
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};

    }

    public static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ComparatorSort.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ComparatorSort.copyArray(arr1);
            quickSort(arr1);
            ComparatorSort.comparator(arr2);
            if (!ComparatorSort.isEqual(arr1, arr2)) {
                succeed = false;
                ComparatorSort.printArray(arr1);
                ComparatorSort.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = ComparatorSort.generateRandomArray(maxSize, maxValue);
        ComparatorSort.printArray(arr);
        quickSort(arr);
        ComparatorSort.printArray(arr);
    }
}
