package swea;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SecondSwea1231_중위순회 {
	
	private static int n;
	private static char[] inputArray;
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	for(int tc=1;tc<=10;tc++) {
		n = sc.nextInt();//8개
		inputArray = new char[n+1];//1번인덱스부터 채울라고
		
		sc.nextLine();//*sc.nextLine()을 쓰기 전에는 그 전 줄 뒤에 있는 공백을 모두 빼줘야 한다. 
		for(int i=1;i<n+1;i++) {
			String string = sc.nextLine();
			StringTokenizer st = new StringTokenizer(string);
			
			st.nextToken();//첫번째 글자 버리기
			inputArray[i] = st.nextToken().charAt(0);
		}
		System.out.print("#"+ tc + " ");
		tree(1);
		System.out.println();
		
	}//테케 끝
	
}//메인끝

private static void tree(int root) {
	if(root<=n) {
		tree(root*2);
		System.out.print(inputArray[root]);
		tree(root*2 +1);
	}
}

}//클래스 끝