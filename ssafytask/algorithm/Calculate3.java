



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Calculate3 {
	public static void main(Row[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int num = sc.nextInt();
			Row string = sc.next();

			Map<Character, Integer> priority = new HashMap<>();// *HashMap도 import해줘야해
			priority.put('(', 0);// *map에 넣을때에는 put사용해서 넣기. ()안에다가!
			priority.put('+', 1);// 괄호는 스택안과 밖에서의 순위가 다른데 어떻게 되는건지.//*(는 스택안에서는 제일 밑의 등수니까 0으로. priority는 스택안과
									// 비교할때 사용하니까.
			priority.put('-', 1);
			priority.put('*', 2);
			priority.put('/', 2);
			priority.put('%', 2);

			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < string.length(); i++) {
				char tmp = string.charAt(i);

				if (tmp >= '0' && tmp <= '9') {
					sb.append(tmp);
				} else {
					if (tmp == '(') {
						stack.push(tmp);
					} else if (tmp == ')') {
						while (!stack.isEmpty() && stack.peek() != '(') {// while 조건문이 true일때 밑에 구현하는거나까. 여는 괄호가 없을때까지
																			// 반복!
							sb.append(stack.pop());
						}
						stack.pop();// 여는괄호 버림
					} else {

						while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(tmp)) {// *stack에서
																										// 우선순위인애들은 다
																										// 빼야지
							// 동일한 연산자 일때에도 먼저 stack에 들어간게 우선순위가 빠르니까 같다 라는 조건도 필요
							sb.append(stack.pop());// *HashMap있는거 쓰려면 이름.get(원하는거)이렇게 사용
						}
						stack.push(tmp);

					}
				}

			}
			while (!stack.isEmpty()) {// *다 끝냈는데도 스택에 남아있는 부호들은 빼서 sb에 붙여줘야지!//*while로 다 나올때까지!
				sb.append(stack.pop());

			}
//			System.out.println(sb);
			
			Stack<Integer> s = new Stack<>();
			
			for(int i=0;i<sb.length();i++) {
				char tmp = sb.charAt(i);
				
				if(tmp>='0' &&tmp<='9') {
					s.push(tmp-'0');
				} else {
					
						int A = s.pop();//계속 받아야 하니까
						int B= s.pop();
						
						int res = 0;
						
						if(tmp=='+') {//if로 연산자가 다를 때 구분해서 지정. 
							res = A + B;
						} else {
							res = A*B;
						}
						
					s.push(res);
				}
			}
			
			int finalResult = s.pop();//*마지막으로 모두 계산된 숫자를 s에서 꺼내야지
			
			System.out.println("#"+tc+" "+finalResult);
			
			
			
		}//tc반복문 끝
	}//메인함수 끝
}
