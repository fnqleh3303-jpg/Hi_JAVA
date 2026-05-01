package swea;

import java.util.Scanner;

public class Swea1227_미로2 {

	static int[][] map;
	static boolean[][] check;
	
	static Point start;//다른 클래스에 있는걸 어떻게 메인에서 들고오는거지
	static Point end;//*이렇게 일단 static으로 빼서 
	
	private static class Point {// 클래스 만들 때 이상하게 자료형 고민하지 말고! 얜 클래스야!!
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int tc = 0; tc < 10; tc++) {

			int T = sc.nextInt();

			map = new int[100][100];
			check = new boolean[100][100];
			StringBuilder sb = new StringBuilder();//스트링빌더 초기 설정 어떻게 하더라 *이렇게 new로 생성하기!

			for (int i = 0; i < 100; i++) {
				String line = sc.next();// *라인으로 받으려면 String으로 하는거네.
				
				for (int j = 0; j < 100; j++) {
					map[i][j] = line.charAt(j) - '0';// *맵 ij에 넣을건데 지금 바뀌는게 j니까 charAt()안에 j가 들어간다.
					
					if(map[i][j]==2) {
						start = new Point(i, j);
						
					} else if(map[i][j]==3) {
						end = new Point(i, j);
					}
				}
			}//할당 끝
			
			
			boolean dap = dfs(start.r, start.c);//안에 인자는 start안에 있는 거 두개를 넣고 싶은데 어떻게 해야하는거지?
			//*클래스 안에 인지 접근 할 때에는 .으로 접근
			
			sb.append("#").append(T).append(" ").append(dap ? 1 : 0);
			
			System.out.println(sb);
			
		}//테케 끝
	}//메인 끝

	private static boolean dfs(int r, int c) {//*여기서 받는 인자는 어짜피 그냥 숫자 두개니까. 
		//지금 위치
		
		//끝지점에 도착했다면 return해줘
		if(map[r][c]==3) {
			return true;
		}
		
		//벽이 아니라면
		if(map[r][c]==1) {//*아오 은하야 벽이라면 false잖아!!!
			return false;
		}
		//방문하지 않았다면
		if(check[r][c]) {
			return false;
		}
		//여기로 가봐
		check[r][c] = true;
		
		//미래 위치
		int[] row = {-1, 0, 1, 0};
		int[] col = {0, 1, 0, -1};
		
		for(int k=0;k<4;k++) {//*4방향 다 가야지 왜 1부터 넣어놓은거야!!
			
			int nextR = r+row[k];
			int nextC = c+col[k];
			
			if(!check[nextR][nextC]) {
				
				//다음 위치로 이동하는 거면 map을 벗어나는건 아닌지 확인해야 해!
				if(map[nextR][nextC]<0||map[nextR][nextC]>=100) continue;
				
				if(dfs(nextR, nextC)) {
					return true;
				}
			}
		}
		
		return false;
	}
}//클래스 끝
//5시 4반