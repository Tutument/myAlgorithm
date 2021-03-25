package com.example.myalgorithm.sort;

/**
 * 荷兰国旗问题
 */
public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] arr = new int[]{9,2,3,5,3,1,7};
        final int[] pattion = pattion(0, arr.length - 1, arr, 3);
        for (int i : pattion) {
            System.out.print(i);
        }
        System.out.println("");
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static int[] pattion(int L, int R, int[] arr, int p) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {

            if (arr[cur] < p) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > p) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
