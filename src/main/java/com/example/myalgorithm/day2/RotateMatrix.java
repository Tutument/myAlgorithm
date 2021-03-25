package com.example.myalgorithm.day2;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int ah = 0;
        int al = 0;
        int bh = arr.length - 1;
        int bl = arr[0].length - 1;
        while (ah < bh) {
            rotateChange(arr, ah++, al++, bh--, bl--);
        }
        printMatrix(arr);
    }

    public static void rotateChange(int[][] arr, int ah, int al, int bh, int bl) {
        int times = bl - al;
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = arr[ah][al + i];
            arr[ah][al + i] = arr[bh - i][al];
            arr[bh - i][al] = arr[bh][bl - i];
            arr[bh][bl - i] = arr[ah + i][bl];
            arr[ah + i][bl] = tmp;
        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
