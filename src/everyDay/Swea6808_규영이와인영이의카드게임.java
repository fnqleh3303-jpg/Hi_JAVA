package everyDay;

import java.util.Scanner;

public class Swea6808_규영이와인영이의카드게임 {

	static int Gscore, Iscore, win, lose;
	static int[] gue, in;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			gue = new int[9];// *인당 9장씩 나눠줘.
			boolean[] guess = new boolean[19];
			in = new int[9];

			for (int i = 0; i < 9; i++) {
				gue[i] = sc.nextInt();

				guess[gue[i]] = false;// *반복문 안돌리고 인덱스 안에 인덱스 넣어서 표현 가능
			} // 할당 완료

			int j = 0;
			for (int i = 0; i < 18; i++) {
				if (!guess[i]) {// *반대가 인영이 카드니까 느낌표 넣기
					in[j++] = i;
				}
			} // 인영이 카드도 다 채웠다.

			win = 0;// win이랑 lose는 테케 하나마다 한번씩만 초기화 하면 되니까 여기 위치하기!
			lose = 0;

			dfs(0);

			System.out.println("#" + tc + " " + win + " " + lose);

		} // 테케 끝
		sc.close();
	}// 메인 끝

	private static void dfs(int idx) {// *라운드 끼리만 비교해야한다.

		// 종료

		if (idx == 9) {// 다 돌았을 때,
			Gscore = 0;// 여기 점수 초기화는 어디서 해야하는거지? 일단 순서 다 바꾸고 나서 계산하려면 여기.
			Iscore = 0;// 여기도

			for (int i = 0; i < 9; i++) {
				int sum = gue[i] + in[i];

				if (gue[i] > in[i]) {
					Gscore += sum;
				} else if (gue[i] < in[i]) {
					Iscore += sum;
				}
			}

			if (Gscore > Iscore) {
				win++;
			} else if (Gscore < Iscore) {
				lose++;
			}

			return;
		}
		// 반복
		for (int i = idx; i < 9; i++) {
			swap(idx, i);
			dfs(idx + 1);
			swap(idx, i);
		}

	}

	private static void swap(int a, int b) {
		int temp = in[a];
		in[a] = in[b];
		in[b] = temp;

	}
}// 클래스 끝
//3시 57븐
