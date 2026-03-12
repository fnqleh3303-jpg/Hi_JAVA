package swea;

import java.util.Scanner;

public class Swea7733_치즈도둑 {

	static int[][] map;
	static boolean[][] visited;
	static int n, limit, count, max;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			limit = 1;//이번 테케 값중에 가장 큰 값을 넣을 거야. 
			map = new int[n][n];//*처음 크기 정의 해야지

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();

					limit = Math.max(limit, map[i][j]);// max 까지만 돌아도 되니까 넣으면서 가장 큰 값 찾기
				}
			} // 할당 긑
			
			max=1;//*왜냐면 일단 처음 상태 자체도 1덩이니까

			for (int i = 0; i <= limit; i++) {//i날짜는 0일부터 limit일까지만
				visited = new boolean[n][n];//*얘는 날짜마다 초기화 되야하는거니까 위치가 여기 아오.
				count = 0;//*일단 기본으로 한 덩이 이지만 밑에서 count를 할거니까 일단은 0으로 둬야지. 

				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {

						if (map[x][y] > i && !visited[x][y]) {// 만약 day 보다 크고, 방문한 적이 없다면
							count++;//연결된 한 바퀴를 다 돌고 들어와야지 count++하지
							dfs(x, y, i);//*0, 0, 0이면 for문 돌리는 의미가 없잖아.
						}

					}
				}

				max = Math.max(max, count);
		}
			System.out.println("#" + tc + " " + max);

		}//테케 끝
	}

	private static void dfs(int i, int j, int day) {
		visited[i][j] = true;// 지금 방문했다고 표시해놓기

		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];

			if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc] && map[nr][nc] > day) {
		 		dfs(nr, nc, day);//d+1이 아니고 d가 되야지. 아직 for문 안인걸
			}
		} // 탐색

	}

}
//*이거 뭔데에에!!! 정말 돌아버리겠구망 4시 44분까지만 생각해보기

