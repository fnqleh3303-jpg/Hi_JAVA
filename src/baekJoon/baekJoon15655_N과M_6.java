package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class baekJoon15655_N과M_6 {

	static int n, m;
	static int[] given, ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		given = new int[m];

		for (int i = 0; i < m; i++) {
			given[i] = sc.nextInt();
		}

		Arrays.sort(given);//사전 순으로 증가하는 순서로 출력

		ham(0, given[0]);

	}

	private static void ham(int idx, int start) {
		// 종료
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			System.out.println(sb);
		}

		// 재귀
		for (int i = start; i < n; i++) {
			ans[idx] = given[i];
			ham(idx + 1, start + 1);
		}

	}

}
