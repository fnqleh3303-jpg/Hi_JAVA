//스캐너로 입력받을거야. 
//파일을
//tc도는 for문 1부터 <=10
//첫줄에 연산자 몇개, sc.nextInt();
//스택 만들, sb만들
//string으로 cal 변수 만들고 받기, sc.nextInt();
//for문으로 cal안에 tem 변수로 탐색
//숫자일 때 sb.append
//연산자 일때 //(이면 stack.push
//)이때 sb.append(stack.peek)
//비어있다면 stack.push
//비어있지 않다면 &&우선순위 while(스텍 peek이 tmp.charAt보다 크거나 같아면  *같을때에는 먼저  stack에 들어간게 우선순위/
//sb.append(stack.pop)
//while문 나와서는 그냥 stack.pop() *(가 나오면 pop으로 제거. 
//while(! stack.isempty)
//sb.append(stack.pop)		//sb완성

//새로운 stack 만들기.
//sb한글자씩  char로 변환하는 for문
//for문 안에서 숫자라면 -'0'을 한다. //여기서 String으로 한 글자씩 있는게 int형으로 컴퓨터 인식.
//for문으로 sb.length만큼 반복
//if 숫자일때는 stack에 넣는다.
//연산자의 경우 b = pop **먼저 pop된게 뒤로 가서 계산이 되야한다. 
//a = pop
//tmp = (a 연산자 b로) 한걸 다시 stack에 넣는다 = tmp를 스택에 넣는다. 
//스텍에 남은 마지막 정답 꺼내기. 
//println을 하는데 ("#"+tc + " "+ tmp) 완전 끝

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Swea_1224 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input (6).txt");// 스캐너로 입력받을거야.
		Scanner sc = new Scanner(file);// 파일을

		Map<Character, Integer> priority = new HashMap<>(); // *제너릭 안에 타입 주의하기 //제네릿 안에는 클래스만 들어갈 수 있어서 기본타입인int 말고
															// 래퍼클래스
		priority.put('+', 1);
		priority.put('*', 2);
		priority.put('(', 0); // *첫번째 스택에는 연산자를 넣으니까 (랑 비교하는 경우가 발생한다!

		for (int i = 1; i <= 10; i++) {// tc도는 for문 1부터 <=10
			int num = sc.nextInt();// 첫줄에 연산자 몇개, sc.nextInt();
			Stack<Character> stack = new Stack<>();// 스택만들기
			StringBuilder sb = new StringBuilder();// 스트링빌더 만들기
			String string = sc.next();

			for (int j = 0; j < string.length(); j++) {
				char tmp = string.charAt(j);// 스트링에서 한 글자씩 쓸거야
				if (tmp >= '0' && tmp <= '9') {// 숫자가 나온다면
					sb.append(tmp);// sb에 넣을거야
				} else {
					if (tmp == '(') {// 여는 괄호가 나온다면
						stack.push(tmp);// 스텍에 넣을거야
					} else if (tmp == ')') {// 닫는 괄호가 나온다면

						while (stack.peek() != '(') {// *스텍에서 (가 나올때까지 다 빼서 확인만 해야하니까 peek
							sb.append(stack.pop());// sb에 붙여
						}
						stack.pop();// (는 버리고

					} else {
						if (stack.isEmpty()) {// 다 비어있으면
							stack.push(tmp);// 그냥 stack에 넣어
						}
						while ((!stack.isEmpty()) && priority.get(stack.peek()) >= priority.get(tmp)) {// 지금 스택에 비어있지
																										// 않고,
																										// 넣으려는 tmp보다
																										// 스택에 있는
																										// 우선순위가 더 우선이라면
							sb.append(stack.pop());// sb에 붙여 //sb.append(tmp) > 계속 sb에 연산자를 붙이는 반복문을 빠져나가지 못함 = 스택을 빼지
													// 않았다.
						} // 아니면
						stack.push(tmp);// stack에 넣어.

					}

				}

			} // for문 끝

			while (!stack.isEmpty()) {
				sb.append(stack.pop()); // *스텍에서 빼서 보기만할건지 없앨건지 제대로 생각하고 코드 작성하기!
			}

			Stack<Integer> st = new Stack<>();// 숫자 넣을 스택 만들기
			for (int j = 0; j < sb.length(); j++) {
				char tmp = sb.charAt(j);// 스트링에서 한 글자씩 쓸거야
				if (tmp >= '0' && tmp <= '9') {
					st.push(tmp - '0'); // 이렇게 적어야지 char에서 Integer로 바뀌는거야. 넣을때 얘를 바꿔서 넣기만 해도 됨.
				} else {
					int a = st.pop();
					int b = st.pop();

					int result = 0;// 연산자랑 계산된 결과를 result변수에 담을 예정
					if (tmp == '+') {
						result = b + a;
					} else {
						result = b * a;
					}
					st.push(result);
				}
			}
			int finResult = st.pop();// 마지막 다 계산된 결과를 스택에서 꺼낸다.

			System.out.println("#" + i + " " + finResult);

		} // tc도는 반복문 끝

	}// 메인함수 끝
}// 클래스 끝
