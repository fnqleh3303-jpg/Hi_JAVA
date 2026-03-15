package swea;


	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Scanner;

	public class Swea1868_파핑파핑지뢰찾기 {
	    static int N;
	    static char[][] map;
	    static int[][] count;
	    static boolean[][] visited;

	    // 8방향
	    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int T = sc.nextInt();

	        for (int tc = 1; tc <= T; tc++) {
	            N = sc.nextInt();
	            map = new char[N][N];
	            count = new int[N][N];
	            visited = new boolean[N][N];

	            for (int i = 0; i < N; i++) {
	                String str = sc.next();
	                for (int j = 0; j < N; j++) {
	                    map[i][j] = str.charAt(j);//일단 주어진 char 할당 완료.
	                }
	            }

	            // 각 칸의 주변 지뢰 수 계산
	            makeCount();

	            int answer = 0;

	            // 주변 지뢰 수가 0인 칸들을 BFS로 확장
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < N; j++) {
	                    if (map[i][j] == '.' && count[i][j] == 0 && !visited[i][j]) {
	                        bfs(i, j);
	                        answer++;
	                    }
	                }
	            }

	            // 아직 방문하지 않은 일반 숫자 칸들은 각각 한 번씩 클릭 필요
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < N; j++) {
	                    if (map[i][j] == '.' && !visited[i][j]) {
	                        answer++;
	                    }
	                }
	            }

	            System.out.println("#" + tc + " " + answer);
	        }

	        sc.close();
	    }

	    // 각 빈 칸('.')의 주변 8방향 지뢰 개수를 계산
	    static void makeCount() {
	        for (int r = 0; r < N; r++) {
	            for (int c = 0; c < N; c++) {
	                if (map[r][c] == '*') continue;

	                int mineCnt = 0;

	                for (int d = 0; d < 8; d++) {
	                    int nr = r + dr[d];
	                    int nc = c + dc[d];

	                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
	                    if (map[nr][nc] == '*') mineCnt++;
	                }

	                count[r][c] = mineCnt;
	            }
	        }
	    }

	    static void bfs(int sr, int sc) {
	        Queue<int[]> q = new LinkedList<>();
	        q.offer(new int[]{sr, sc});
	        visited[sr][sc] = true;

	        while (!q.isEmpty()) {
	            int[] cur = q.poll();
	            int r = cur[0];
	            int c = cur[1];

	            // 현재 칸이 0일 때만 주변으로 확장
	            if (count[r][c] != 0) continue;

	            for (int d = 0; d < 8; d++) {
	                int nr = r + dr[d];
	                int nc = c + dc[d];

	                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
	                if (map[nr][nc] == '*') continue;
	                if (visited[nr][nc]) continue;

	                visited[nr][nc] = true;
	                q.offer(new int[]{nr, nc});
	            }
	        }
	    }
	}

