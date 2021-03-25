package com.example.myalgorithm.day2;

public class PrintMatrixSpiralOrder {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int ah = 0;
        int al = 0;
        int bh = arr.length-1;
        int bl = arr[0].length-1;

        while (ah < bh && al < bl) {
            printSpiralOrder(arr, ah++, al++, bh--, bl--);
        }
    }

    public static void printSpiralOrder(int[][] arr, int ah, int al, int bh, int bl) {
        if (ah == bh) {
            for (int i = 0; i < bl - al; i++) {
                System.out.println(arr[ah][al + i]);
            }
        } else if (al == bl) {
            for (int i = 0; i < bh - ah; i++) {
                System.out.println(arr[ah + i][al]);
            }
        } else {
            int curh = ah;
            int curl = al;
            while (curl < bl) {
                System.out.print(arr[ah][curl] + " ");
                curl++;
            }
            while (curh < bh) {
                System.out.print(arr[curh][bl] + " ");
                curh++;
            }
            while (curl > al) {
                System.out.print(arr[bh][curl] + " ");
                curl--;
            }
            while (curh > ah) {
                System.out.print(arr[curh][al] + " ");
                curh--;
            }
        }

    }
}
