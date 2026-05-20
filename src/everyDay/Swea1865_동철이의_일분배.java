package everyDay;

import java.util.Scanner;

public class Swea1865_동철이의_일분배 {

	static int n;
	static double sum, max;// *1보다 작은 양의 정수가 있으니까 double을 사용해야 한다.
	static int[][] percent;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();

			percent = new int[n][n];
			visited = new boolean[n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					percent[i][j] = sc.nextInt();
				}
			} // 할당 완

			max = 0.0;
			;

			dfs(0, 1.0);//*곱하기로 축적되니까 sum 초기값은 1이 되어야 한다.

			System.out.printf("#%d %.6f%n", tc, max * 100);// *%.6f로 소수점 6자리수까지 실수 나타내기.
		} // 테케 끝
		sc.close();
	}// 메인 끝

	private static void dfs(int row, double sum) {

		// 가지치기
		if (sum <= max) {// *지금 곱하는건 모두 1보다 작은 숫자들이니까 지금까지 곱한 값이 max보다 작다면
			// 여기서 계속 곱해도 결국 더 작아지니까 가지치기를 하는거다.
			return;
		}

		// 종료조건
		if (row == n) {
			max = Math.max(max, sum);// *두개 중에 더 큰걸 따지기는 Math.max로 간편하게!
			return;
		}

		// 반복
		for (int col = 0; col < n; col++) {

			if (!visited[col]) {

				visited[col] = true;

				dfs(row + 1, sum * percent[row][col] / 100.0);// *지금 들어온 숫자들에서 /100을 해야지 계산하는 퍼센트가 되는거다.

				visited[col] = false;
			}
		}
	}

}// 클래스 끝
//10시 56분
