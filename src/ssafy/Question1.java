package ssafy;

//2월 월말평가 알고리즘 기본 1번 문제

import java.util.Scanner;

public class Question1 {

	static class Node {// Node라는 타입 만들기 완.
		String val;
		int left, right;

		Node(String val, int left, int right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static Node[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();// 몇줄 받을건지
			tree = new Node[n + 1];// 1인덱스부터 넣을거야

			for (int i = 0; i < n; i++) {// n줄이니까 반복
				int id = sc.nextInt();
				String val = sc.next();
				int left = sc.nextInt();
				int right = sc.nextInt();
				tree[id] = new Node(val, left, right);
			}
			int targetResult = sc.nextInt();// 할당은 끝
			
			//여기부터는 root가 ?로 연산자를 알 수 없어서 만드는 로직이야.
			long leftVal = evaluate(tree[1].left);
			long rightVal = evaluate(tree[1].right);
			
			char answer = ' ';//아직 정답 모름을 표시, 타입 맞추기, 컴파일 에러 방지가 이유다. 공백char로 처음에 지정하는게
			char[] operators = {'+', '-', '*', '/'};
			
			for(char op: operators) {
				if(calculate(leftVal, rightVal, op)==targetResult) {
					answer = op;
					break;
				}
			}
			
			System.out.println("#"+tc+" "+answer);

		} // 테케 끝

	}// 메인끝

	static long evaluate(int nodeIdx) {//왜 리턴타입이 long일까?//*혹시나 몰라서.
		Node node = tree[nodeIdx];
		
		if(node.left ==0 && node.right ==0) {//자손이 없으면 숫자일거니까
			return Long.parseLong(node.val);
		}
		
		long leftRes = evaluate(node.left);
		long rightRes = evaluate(node.right);
		
		return calculate(leftRes, rightRes, node.val.charAt(0));//node.val.charAt(0)을 함으로써 String형의 val을 char형으로 변환한거다. 
	}
	
	static long calculate(long a, long b, char op) {
		switch (op) {
		case '+': return a+b;
		case '-': return a-b;
		case '*': return a*b;
		case '/': 
			if(b==0) return 0;
			return a/b;
			default: return 0;//연산자 외의 다른게 들어온다면 0리턴한다는 거.
		}
	}
	
}// 클래스 끝
