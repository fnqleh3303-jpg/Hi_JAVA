import java.util.Arrays;
import java.util.Scanner;

public class Swea_4613_러시아국기같은깃발 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] flag = new char[n][m];

			// 아직 매열안에 글자 입력 안받음. 혹시 배열안에 글자를 받으면서 탐색하고 count하는 방법도 있을라나?
			// char로 배열을 채울건데 받는건
			for (int i = 0; i < n; i++) {
				String line = sc.next();// *String으로 받아서 char로 바꾸려면 일단 한줄씩은 string으로 받고, 열을 채울 때 char로 하나씩.
										// 이렇게 하면 string으로 주어져도 한 글자씩 배열에 담을 수 있다.
				for (int j = 0; j < m; j++) {
					flag[i][j] = line.charAt(j);// 여기 배열 안에는 i, j로 변하는 값이 들어가야지.
				}
			} // 배열 할당 끝

			int min = n * m;

			for (int i = 1; i < n - 1; i++) {// 흰색은 여기까지 경계를 정하는 거고.//경계니까 1부터 시작해도 되겠네
				for (int j = i + 1; j < n; j++) {// 파랑은 여기까지 경계정해.

					int count = 0;// *한 케이스가 돌 때마다 초기화 해줘야해
					for (int w = 0; w < i; w++) {// *위에서는 범위만 설정한거고, 여기서 그 경계까지 채워준다.
													// *경계라는게 여기까지 화이트 색칠한다 니까 같다 넣기
						for (int ii = 0; ii < m; ii++) {// 열을 돌면서
							if (flag[w][ii] != 'W') {// W가 아닐 시
								count++;// 센다
							}
						}
					}

					for (int b = i; b < j; b++) {// *경계니까 여기까지 blue 색칠한다니까 같다 넣어야 해.
						for (int jj = 0; jj < m; jj++) {
							if (flag[b][jj] != 'B') {
								count++;
							}
						}
					}

					for (int r = j; r < n; r++) {
						for (int kk = 0; kk < m; kk++) {
							if (flag[r][kk] != 'R') {
								count++;
							}
						}
					} // 여기까지 count축적 완

					if (count < min) {
						min = count;
					}

				}
			}

			System.out.println("#" + tc + " " + min);// *main을 선언했더라도 초기화를 함께 하지 아서 지금 값이 확실하지 않다면 자바는 에러를 낸다.
		} // 테스트케이스 끝

	}// 메인함수 끝
}// 클래스 끝
