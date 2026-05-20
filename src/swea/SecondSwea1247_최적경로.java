package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondSwea1247_최적경로 {

	static int n, min;
	static int[] start, finish;
	static boolean[] visited;//결국에 방문한 곳의 숫자들도 담으려면 boolean배열 필수!
	static int[][] spot;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();

			spot = new int[n][2];// 각 배열 칸 안에 리스트가 들어 있으면 좋겠다.
			// *지금 넣은건 좌표 두개 뿐이니까 2차 배열이면 딱 좋음.

			start = new int[2];
			finish = new int[2];
			min = Integer.MAX_VALUE;
			visited = new boolean[n];// *static선언했다고 초기 설정 안하는 말도 안되는 일 그만. 이렇게 되면 nullPointExceptino에 걸린다.

			for (int i = 0; i < 2; i++) {
				start[i] = sc.nextInt();
			}

			for (int i = 0; i < 2; i++) {
				finish[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				spot[i][0] = sc.nextInt();
				spot[i][1] = sc.nextInt();
			} // 할당 받은 숫자 완료.//첫번째는 출발. 두번째는 도착위치.

			dfs(0, start[0], start[1], 0);

			System.out.println("#" + tc + " " + min);
		} // 테케 끝
	}// 메인 끝

	private static void dfs(int idx, int row, int col, int sum) {
		// 종료조건
		if (idx == n) {
			// 마지막 위치랑 지금 sum이랑 더하기
			sum += Math.abs(finish[0] - row) + Math.abs(finish[1] - col);// *sum에 덮어씌우로 있다.
			min = Math.min(min, sum);// 내가 구하는 건 min이다.
			return;
		}

//		if (idx == 0) {//처음에는 start랑의 거리를 계산해야하니까. *근데 이미 초기 값으로 start 좌표를 적어놔서 이런 생각은 안해도 됨. 
//			sum += Math.abs(start[0] - row) + Math.abs(start[1] - col);
//		}

		for (int i = 0; i < n; i++) {
			
			if (!visited[i]) {
				visited[i] = true;
				int dist = Math.abs(spot[i][0] - row) + Math.abs(spot[i][1] - col);
				
				dfs(idx + 1, spot[i][0], spot[i][1], // 이미 spot[i][0]이랑 spot[i][1]이 현위치를 말하고 있는거다. 지금
						sum + dist);// 지금 비교해야 하는건 현위치-그 전에 있었던 위치다.
				visited[i] = false;
			}

		}
	}
}// 클래스 끝
//9시 43분
//회사에서 출발해서 n명 모두 방문하고 돌아오는 경로
//T	N	좌표
//dfs 메서드에서는 돌아가면서 순서를 바꿔서 총 거리를 구하기. 그러고 종료조건에서 min을 찾는거야.
//모든 곳을 다 방문하고 순서를 맞춰서 들어가려면 어떻게 해야하나. 일단 ArrayList로 받았으니까
//|x1-x2| + |y1-y2|로 거리를 구할 수 있다. 