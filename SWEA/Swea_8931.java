import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Swea_8931 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("8931.txt");
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 테스트 케이스 수 TC입력
		for (int i = 1; i <= N; i++) { // K번째 테스트 케이스
			int K = sc.nextInt();
			int sum = 0;
			int a =0;

			Stack<Integer> stack = new Stack<>();// stack 불러오기

			for (int num = 0; num < K; num++) {// num개의 줄.
				a = sc.nextInt();
				if (a == 0) {//a는 실제 스택 안에 들어가는 숫자.

					stack.pop();
				} else {
					stack.push(a);// push로 넣기
				}

			} // 각 테스트 케이스 안의 case번 입력 끝
			int n = stack.size();//스택 길이를 고정시켜놔야지 for문에 문제 없음. 두개다 변동이 있을 시에는 stack의 반까지만 가기 때문에 내가 원하는대로 모두 sum으로 더하지 못하게 된다. 
			for(int j=0;j<n;j++) {
				
//				sum += stack.get(j); // 얘도 어쨋든 list 밑에 있으니까 get사용.
				sum += stack.pop(); // n을 처음 stack사이즈로 고정을 해야지 pop을 할 때 마지막것만 
			}
			
			System.out.println("#" + i + " " + sum);
		} // 테스트 케이스 갯수 끝
		sc.close();
	}// 메인함수 끝

}// 클래스 끝
