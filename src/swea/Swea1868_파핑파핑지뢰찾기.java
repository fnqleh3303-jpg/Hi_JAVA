package swea;

import java.util.Scanner;

public class Swea1868_파핑파핑지뢰찾기 {
	private static class mark{
		int r, c;

		public mark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int T = sc.nextInt();
			for(int tc=1;tc<=T;tc++) {
				int n = sc.nextInt();
				
				char[][] map = new char[n][n];
				
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						map[i][j] = sc.next();
					}
				}
			}
		}
		
	}
}
