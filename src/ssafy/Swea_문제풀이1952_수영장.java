package ssafy;

import java.util.Scanner;

public class Swea_문제풀이1952_수영장 {
	static int d, m1, m3, y;// 일일권, 한달권, 세달권, 연간권
	static int[] month; // 각달의 이용계획
	static int ans; // 정답(최소비용 가격)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			d = sc.nextInt();// 일일권
			m1 = sc.nextInt();// 한달권
			m3 = sc.nextInt();// 세달권
			y = sc.nextInt();// 연간권

			month = new int[13]; // 12월이라는 값을 직접 인덱스와 맞추고 싶어서

			for (int i = 1; i < 13; i++) {
				month[i] = sc.nextInt();
			}

//		ans = Integer.MAX_VALUE;//보통 최소 비용을 구해라! -> 아주 큰 수로 초기화.
//		ans = 987654321;

			ans = y; // 1년권으로 초기화를 시킨다.
			swimfee(1, 0);// 1월부터 0원을 가지고 보내겠다.

			System.out.println("#" + tc + " " + ans);

		} // 테케
	}// 메인 함수

//m:이용권을 고르기 위한 달
//fee:지금까지 누적해온 요금
	static void swimfee(int m, int fee) {
		// ans는 내가 베스트라고 알고 있는 값
		// fee 누적시키고 있는 값이야. fee가 ans를 넘어버리면 더이상 할 필요는 없다.

		// 해당 이용계획이 0일인 경우에는...
		//

		// 종료파트
		if (m >= 13) {// 종료파트에 ==으로 하는거면 조금 생각을 해봐야함. 왜냐면 지금 상태에서는 11월이나 12월에 3달 이용권을 사서 무한으로
			// 재귀를 돌 수도 있으니까.

			// 현재 가지고 있는 정답과 이번에 만들어진 fee를 가지고 갱신
			// 두개의 값을 가지고 갱신을 한다.
			ans = Math.min(ans, fee);
//		ans = ans>fee ? fee: ans;

			return;
		}

//		// 재귀파트
//		// 1일권
//		swimfee(m + 1, fee + d * month[m]);// 일일권을 몇번쓸지
//
//		// 한달권
//		swimfee(m + 1, fee + m1);

		//한달을 한방에 처리하자 최소비용을 구하려는 거니까
		swimfee(m+1, fee + Math.min(d*month[m], m1));
		
		// 세달권
		swimfee(m + 3, fee + m3);

	}
}
