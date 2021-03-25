package com.example.myalgorithm.sort;

import java.util.Arrays;

public class SelectSort {


    public static void selectionSort(int arr[]) {

        for (int i = 0; i <arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                min = arr[min] < arr[j] ? min : j;
            }
            swap(arr,min,i);
        }
      /*  for (int i : arr) {
            System.out.println(i);
        }*/

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ComparatorSort.generateRandomArray(maxSize, maxValue);
            int[] arr2 = ComparatorSort.copyArray(arr1);
            selectionSort(arr1);
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
        selectionSort(arr);
        ComparatorSort.printArray(arr);
    }
}
