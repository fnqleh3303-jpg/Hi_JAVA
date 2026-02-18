package swea;

import java.util.Scanner;

public class Swea1984_중간평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int max = 0;
			int min = 10000;
			int[] row = new int[10];//*stringBuilder보다 배열이 더 깔끔한 문제
			double sum = 0;

			for (int j = 0; j < 10; j++) {
				int tmp = sc.nextInt();
				row[j] = tmp;

				if (tmp > max) {
					max = tmp;
				}
				if (tmp < min) {
					min = tmp;
				}

			} // 배열 채우기 끝
			for (int j = 0; j < 10; j++) {

				if (row[j] != min && row[j] != max) {
					sum += row[j];
				}
			}
			System.out.printf("#%d %d\n", i, Math.round(sum/8.0));

		} // tc 끝

	}

}
