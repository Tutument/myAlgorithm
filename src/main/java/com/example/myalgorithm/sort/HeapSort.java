package com.example.myalgorithm.sort;

public class HeapSort {

    public static void heapSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapfiy(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    /* public static void heapInsert(int[] arr, int index) {
         while (arr[index] > arr[(index - 1) / 2]) {
             swap(arr, index, (index - 1) / 2);
             index = (index - 1) / 2;
         }

     }

     public static void heapfiy(int[] arr, int index, int size) {
         int left = index * 2 + 1;
         while (left < size) {
             int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
             largest = arr[index] > arr[largest] ? index : largest;
             if (largest == index) {
                 break;
             }
             swap(arr, largest, index);
             index = largest;
             left = index * 2 + 1;
         }

     }*/
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    public static void heapfiy(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] >arr[largest]? index:largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = 2*index+1;
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
            heapSort(arr1);
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
        heapSort(arr);
        ComparatorSort.printArray(arr);
    }
}
