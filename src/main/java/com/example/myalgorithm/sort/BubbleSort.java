package com.example.myalgorithm.sort;

public class BubbleSort {

    public static void bubomSort(int arr[]){

        for(int i=arr.length-1; i>0; i--){
            for(int j=0; j< i ; j++){
                if(arr[j] > arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }

    public static void swap(int arr[], int i, int j){
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
            bubomSort(arr1);
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
        bubomSort(arr);
        ComparatorSort.printArray(arr);
    }
}
