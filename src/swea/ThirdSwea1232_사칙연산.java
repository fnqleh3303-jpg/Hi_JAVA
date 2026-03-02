package swea;

import java.util.Scanner;

public class ThirdSwea1232_사칙연산 {
	private static class Node {// 메서드만 return 타입 적어줘
		String value;
		int left, right;// 자식번호 없으면 0으로

		Node(String value) {
			this.value = value;// node value를 입력하면 여기 안에 value값으로 들어간다.
		}

	}

	static Node[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			tree = new Node[n + 1];

			for (int i = 1; i < n + 1; i++) {
				int id = sc.nextInt();
				String input = sc.next();
				tree[id] = new Node(input);

				if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
					tree[id].left = sc.nextInt();
					tree[id].right = sc.nextInt();
				}
			}
			double res = calculate(1);
			System.out.println("#" + tc + " " + (int)res);

		} // 테케 끝

	}// 메인 끝

	private static double calculate(int idxNum) {
		Node node = tree[idxNum];// 물론 메서드에서 tree[idxNum]이라고 계속 써줘도 되지만,
		// 효율을 위해 node라고 부르기로 한거야.

		if (node.left == 0 && node.right == 0) {
			return Double.parseDouble(node.value);
		}

		double a = calculate(node.left);
		double b = calculate(node.right);

		switch (node.value) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "/":
			return a / b;
		}
		return 0;// 에러를 위한 예의

	}

}
