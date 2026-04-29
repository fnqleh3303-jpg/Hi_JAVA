package swea;

import java.util.Scanner;

public class Swea1226_미로1 {

	static int[][] map;
	static boolean[][] check;

	static int finR, finC;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();

			int startR = 0;
			int startC = 0;
			finR = 0;
			finC = 0;

			map = new int[16][16];
			check = new boolean[16][16];

			for (int i = 0; i < 16; i++) {
				String line = sc.next();

				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) - '0';// line으로 받아서 하나씩 charat하면 문자니까 숫자로 바꾸려면 -'0'필수!
//					map[i][j] = sc.nextInt();//왜 여기 넣는데서 문제가 생기니? inputmismatchexception???아 띄어쓰기 없이 들어오는거네

					if (map[i][j] == 2) {
						startR = i;
						startC = j;
					}

					if (map[i][j] == 3) {
						finR = i;
						finC = j;
					}
				}
			} // 할당 끝

//			System.out.println(Arrays.deepToString(map));

			boolean dap = dfs(startR, startC);
			
			System.out.println("#" + T + " " + (dap ? 1 : 0));// *삼항연산자는 원하는 결과를 t:f처럼 땡땡으로 구분해야한다.

		} // 테케 끝
		sc.close();

	}// 메인 끝

	private static boolean dfs(int startR, int startC) {
		// 현재위치
		int[] row = { -1, 0, 1, 0 };
		int[] col = { 0, 1, 0, -1 };

		// *벽이야? 벽 > 방문 순서로 물어보는게 더 자연스럽대
		if (map[startR][startC] == 1)
			return false;

		// 방문했어?
		if (check[startR][startC])//*방문을 한거면 가면 안되니까 false네. 답이 원하는게 안나오면 논리로 따라가서 고치기!
			return false;

		check[startR][startC] = true;

		// finish에 도달했니?
		if (startR == finR && startC == finC)
			return true;

		// next위치에서
		for (int i = 0; i < 4; i++) {
			int nextR = startR + row[i];
			int nextC = startC + col[i];

			// 이미 방문한 곳이야?
			if (!check[nextR][nextC])// *이 길로 가도 되니까!
				if (dfs(nextR, nextC))// *다음 길로 갈 수 있다면
					return true;// true를 반환하는거지 여기로 시작하면 결국 갈 수 있다!라는걸. dfs메서드에 return하는거라 70번째 줄이랑 다르다.
		}
		return false;
	}
}// 클래스 끝
//11시 6분.