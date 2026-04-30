package swea;

import java.util.Scanner;

public class Swea1227_미로2 {

	private static class Point {// 클래스 만들 때 이상하게 자료형 고민하지 말고! 얜 클래스야!!
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		static Point start;//다른 클래스에 있는걸 어떻게 메인에서 들고오는거지
		static Point end;

		for (int tc = 0; tc < 10; tc++) {

			int T = sc.nextInt();

			int[][] map = new int[100][100];
			boolean[][] check = new boolean[100][100];

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
			
			boolean dap = dfs(start);//안에 인자는 start안에 있는 거 두개를 넣고 싶은데 어떻게 해야하는거지?
			
			
		}//테케 끝
	}//메인 끝

	private static boolean dfs() {
		
		return false;
	}
}//클래스 끝
//5시 4반