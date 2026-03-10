package swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Swea5521_상원이의생일파티 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
//			List<Integer>[] friends = new ArrayList[m];//왜 <>를 지우니까 에러가 없어지는거지?
			int[][] friends = new int[n + 1][n + 1];// 1부터 시작하니까 n+1로 크기 잡기
			boolean[] isHere = new boolean[n + 1];

			for (int i = 0; i < m; i++) {
//				friends[i] = new ArrayList<>();//새로운걸 계속 만드는거니까 new를 붙여야지
				int a = sc.nextInt();
				int b = sc.nextInt();

				friends[a][b] = 1;
				friends[b][a] = 1;

			} // 일단 노드 완료

			for (int i = 1; i <= n; i++) {
				if (friends[1][i] == 1) {// 상원이의 제일 친한 친구
					isHere[i] = true;


					for (int j = 1; j <= n; j++) {// 제일 친한친구의 친구

						if (friends[i][j] == 1) {
							isHere[j] = true;
						}
					}
				}
			}
			int count=0;
			for(int i=2;i<=n;i++) {
				if(isHere[i]) count++;
			}

			System.out.println("#" + tc + " " + count);

		} // 테케 끝
	}// 메인 끝
}// 클래스 끝

//방문체크는 boolean으로 흔적을 남기자
