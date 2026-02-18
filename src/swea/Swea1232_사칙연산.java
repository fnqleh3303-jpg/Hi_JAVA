package swea;

import java.util.Scanner;

public class Swea1232_사칙연산 {
	private static String[] row;
	private static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {// 10번 반복하라.
			if (!sc.hasNext())
				break;// 입력이 없으면 break해라
			int n = sc.nextInt();// 우선 몇 줄이 나올지 받고

			row = new String[n + 1];// 각 값을 넣을 배열 생성
			map = new int[n + 1][2];// children과의 관계를 나타내줄 배열 생성

			for (int i = 1; i <= n; i++) {// 그 줄의 갯수만큼 반복할거야.
				int idx = sc.nextInt();
				String second = sc.next();//*연산자 일수도 있고 숫자일수도 있으니까 string으로 받기

				row[idx] = second;//*진짜 방번호인 idx에 넣어야지

				if (second.equals("+") || second.equals("-") || second.equals("*") || second.equals("/")) {
					map[idx][0] = sc.nextInt();//*여기도 i가 아니라 idx 행에 넣는게 맞지.
					map[idx][1] = sc.nextInt();
				}
			}

			System.out.println("#" + tc + " " + (int)calculate(1));

		}
		sc.close();
	}// 메인함수

	private static double calculate(int i) {
		String num = row[i];// row에 넣어뒀던 값==node안의 값

		if (num.equals("+") || num.equals("-") || num.equals("*") || num.equals("/")) {// *연산자라면?을 먼저 해야해. 왜냐면 연산자 일때 재귀로
																						// 이제껏 계산한 앞 뒤 내용을 가져오는 거니까.

			double left = calculate(map[i][0]);//*calculate로 이 전의 계산들을 다시 가지고 오는게 재귀의 꽃이지.
			double right = calculate(map[i][1]);

			switch (num) {
			case "+":
				return left + right;
			case "-":
				return left - right;
			case "*":
				return left * right;
			case "/":
				return left / right;
			}
			return 0;
		}
		return Double.parseDouble(num);

	}

}
