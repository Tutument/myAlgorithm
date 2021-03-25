package com.example.myalgorithm.sort;

public class InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1;  j >= 0  && arr[j] > arr[j + 1] ; j--) {
                swap(arr, j, j + 1);
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ComparatorSort.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ComparatorSort.copyArray(arr1);
            insertSort(arr1);
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
        insertSort(arr);
        ComparatorSort.printArray(arr);
    }
}
