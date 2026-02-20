package swea;

import java.util.Scanner;

public class Swea1206_view {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {// 테케 10개
			int n = sc.nextInt();// 빌딩갯수 몇개?
			int[] buildings = new int[n];// 빌딩 수만큼 배열생성
			int count = 0;// 결과 값 count

			for (int i = 0; i < buildings.length; i++) {// 배열에 입력받는 값 할당
				buildings[i] = sc.nextInt();
			}//*할당 먼저 끝내고 배열에 들어가 있는 값에 접근해야지!
			
			for (int j = 2; j < n - 2; j++) {
				int around = Math.max(buildings[j - 2],
						Math.max(buildings[j - 1], Math.max(buildings[j + 1], buildings[j + 2])));
				if (buildings[j] > around) {
					count += buildings[j] - around;
				}
			}

			System.out.printf("#%d %d", tc, count);
			System.out.println();
		} // 테케 끝
	}// 메인함수
}
//for문 1>10
//int n 받기
//n크기로 배열 생성
//for문 0>n
//배열[i]에 숫자들 할당
//for(2>n-2)
// around 변수에 [i-2]에서 [i+2]까지 중에 max찾고
//만약 i가 around보다 크다면 i값-max해서 count++
