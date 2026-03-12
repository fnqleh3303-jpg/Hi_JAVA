package ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea1953_탈주범검거 {
	static int N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visited;

	// 우하좌상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	// 터널의 정의(타입별)
	static int[][] tunnel = { // 갈 수 있는 방향 저장
			{}, // 왜 첫번째는 버리는거지?
			{ 0, 1, 2, 3 }, { 1, 3 }, { 0, 2 }, { 0, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, };

	static class Person {
		int r, c, time;

		public Person(int r, int c, int time) {
//			super();  얘를 없애는 이유는 뭐지?
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();// 시간은 1~20;

			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();

				}
			}//할당 끝
			ans=1;
			
			bfs();
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void bfs() {
		Queue<Person> q = new LinkedList<>();
		q.offer(new Person(R, C, 1));
		visited[R][C] = true;
		
		while(!q.isEmpty()) {
			Person p = q.poll();
			
			//탈주범이 주어진 시간만큼 이동했다. (continue가 아닌 break일 때 문제는 없을까?)
			if(p.time ==L) continue;
			
			int type = map[p.r][p.c];//현재 탈주범이 서있는 위치의 터널!
			//현재터널에서 갈 수 있는 방향만 확인을 하면 되겠다. 
			for(int dir : tunnel[type]) {
				int nr = p.r + dr[dir];
				int nc = p.c + dc[dir];
				
				//범위쳌, 방문쳌//*언제나 범위 첵이 먼저 해야 한다. 
				if(nr<0||nc<0||nr>=N||nc>=M||visited[nr][nc]) continue;
				//터널체크
				if(map[nr][nc]==0) continue; //터널이 없다!
				
				int nextType = map[nr][nc];
				int dir2 = (dir + 2) %4;//반대 방향 만들기
				
				// 다음 타입이 현재있는 좌표와 연결이 되어 있어야 할듯!
				if (!canMove(nextType, dir2))
					continue; // 갈수없다!

				visited[nr][nc] = true;
				ans++;
				q.offer(new Person(nr, nc, p.time + 1));
			}
			
			
		}
		
	}//bfs메서드
	
	//type안에 dir이 있는지 쳌
	static boolean canMove(int type, int dir) {
		for(int d:tunnel[type]) {
			if(d==dir) return true;
		}
		
		return false;
	}
}
