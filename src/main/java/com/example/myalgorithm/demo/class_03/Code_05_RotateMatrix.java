package com.example.myalgorithm.demo.class_03;

/**
 * 矩阵（正方形）旋转
 */
public class Code_05_RotateMatrix {

	public static void rotate(int[][] matrix) {
		int ah = 0;
		int al = 0;
		int bh = matrix.length - 1;
		int bl = matrix[0].length - 1;
		while (ah < bh) {
			rotateEdge(matrix, ah++, al++, bh--, bl--);
		}
	}

	public static void rotateEdge(int[][] m, int ah, int al, int bh, int bl) {
		int times = bl - al;
		int tmp = 0;
		for (int i = 0; i != times; i++) {
			tmp = m[ah][al + i];
			m[ah][al + i] = m[bh - i][al];
			m[bh - i][al] = m[bh][bl - i];
			m[bh][bl - i] = m[ah + i][bl];
			m[ah + i][bl] = tmp;
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

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("=========");
		printMatrix(matrix);

	}

}
