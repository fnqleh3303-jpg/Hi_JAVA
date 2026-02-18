package swea;

import java.util.Scanner;
import java.util.Stack;

public class Swea_1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
// 1. 10번 반복하는 tc for문
		for (int tc = 1; tc <= 10; tc++) { // 주어진 10개의 테스트 케이스 for문으로 돌기
			int n = sc.nextInt();// string안에 n개의 character있는지 숫자 받기
			String a = sc.next();// a는 string(괄호묶음)받기
			Stack<Character> stack = new Stack<>();// 일단 열린 괄호를 넣을 stack만들기. 여기에는 괄호가 들어가야하니까 character가 들어가는거야.
			boolean isOk = true; // 일단 true로 시작!

			// 2. 문자열 하나하나 검사하는 for문
			for (int i = 0; i < n; i++) {// string안에 있는 문자를 하나씩 확인하는 for문. i는 string 안에서 인덱스 역할.
				char c = a.charAt(i);// 그 인덱스에 해당하는 괄호를 지칭하기에 너무 길어서 char c를 만든거야.

				// 여는 괄호면 스택에 push
				if (c == '(' || c == '[' || c == '{' || c == '<') {// 만약 여는 괄호 4종류 중 하나라면
					stack.push(c);// stack에 넣도록 해.
				}
				// 닫는 괄호인 경우 (else)
				else {
					// [교정] 꺼낼 게 없으면 실패!
					if (stack.isEmpty()) {// 만약 더 껄낼게 없다.
						isOk = false;//
						break;
					}

					char open = stack.pop(); // 일단 하나 꺼내서 확인

					// [교정] 짝이 맞는지 하나하나 확인 (님께서 말씀하신 4개의 if문)
					if (c == ')' && open != '(')
						isOk = false;
					else if (c == ']' && open != '[')
						isOk = false;
					else if (c == '}' && open != '{')
						isOk = false;
					else if (c == '>' && open != '<')
						isOk = false;

					if (!isOk)
						break; // 짝이 안 맞으면 바로 탈출
				}
			}

			// 3. 최종 판단: 중간에 에러가 없어야 하고(isOk), 스택도 깨끗이 비워져야 함
			if (isOk && stack.isEmpty()) {
				System.out.println("#" + tc + " 1");
			} else {
				System.out.println("#" + tc + " 0");
			}
		}
	}
}