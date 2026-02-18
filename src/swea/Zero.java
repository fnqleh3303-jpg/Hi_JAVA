package swea;

import java.util.Scanner;
import java.util.Stack;

public class Zero {
	public static void main(Row[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			int num = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			int sum = 0;

			for (int i = 0; i < num; i++) {// 숫자 한줄씩 받을거야
				int tmp = sc.nextInt();

				if (tmp == 0) {// *따로따로 if가 3번 되면, 계속해서 stack에 들어가거나 나가는 오류가 발생하니까 최대한 합쳐서 문제 없게 짜야해.
					if (stack.isEmpty()) {
						stack.push(tmp);
					} else {
						stack.pop();
					}
				} else {
					stack.push(tmp);//*tmp가 0이 아닐때의 조건을 까먹었다!
				}
			}

			int stackSize = stack.size();

			if (!stack.isEmpty()) {

				for (int j = 0; j < stackSize; j++) {

					sum += (stack.pop());
				}

			}
			System.out.println("#" + t + " " + sum);
		} // tc 끝
	}// 메인 끝
}// 클래스 끝
