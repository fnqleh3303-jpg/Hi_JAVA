package swea;

import java.util.Scanner;

public class Swea1247_최적경로 {

	static int[][] map;
	static int n;
	static int min;
//	static int distance;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;// *테케 돌때마다 초기화를 해야지 쌓이지 않으니까 여기서 초기화!

			n = sc.nextInt();
			map = new int[n + 2][2];
			
			//회사
			map[0][0] = sc.nextInt();
			map[0][1] = sc.nextInt();
			
			//집
			map[n+1][0] = sc.nextInt();
			map[n+1][1] = sc.nextInt();

			//고객
			for (int i = 1; i < n + 1; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			
			shortest(1);//*이 부분이 있어야 shortest 함수를 사용하는거지 바보야//*인덱스 1부터 고객 너가 넣었잖아
			System.out.println("#" + tc + " " + min);// *static으로 위에 min을 올려놨고, shortest함수는 void로 반환하기는하지만 min값을
			// 계산해 주는거니까 자동적으로 얜 계산이 되는거다!
		} // 테케 끝
	}// 메인 끝

	private static void shortest(int x) {
		
		// 종료
		if (x == n+1) {//고객집을 다 돌면
			int sum = 0;// *지역변수는 무조건 초기화 해야지!

			for (int i = 1; i <= n; i++) {//*i는 언제나 첫번째 고객부터 돌아야지

				int length = Math.abs(map[i][0] - map[i - 1][0]) + Math.abs(map[i][1] - map[i - 1][1]);
				sum += length;
			}
			
			int toHome = Math.abs(map[n][0] - map[n+1][0]) + Math.abs(map[n][1] - map[n+1][1]);//*인덱스 번호 헷갈리지 않기!ㄴ
			
			sum += toHome;
			
			if (min > sum) {
				min = sum;
			}
			
			return;
		}
		// 재귀
		for (int i = x; i <= n; i++) {
			swap(i, x);
			shortest(x + 1);
			swap(i, x);
		}

	}

	static void swap(int a, int b) {
		int tmp = map[a][0];
		map[a][0] = map[b][0];
		map[b][0] = tmp;
		
		int tmp2 = map[a][1];//*y좌표도 swap해야지
		map[a][1] = map[b][1];
		map[b][1] = tmp2;
		
	}
}// 클래스 끝
//10시

//static void map(int a, int b) { //생각해보기. 2차배열 반전이군
//	int[]tmp = map[a];
//	map[a] = map[b];
//	map[b] = tmp;
//	
//}
