package swea;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.ForkJoinPool;

public class Swea1231_중위순회 {
	private static int nodeCount;//*다른 함수에서도 사용해야하니까 클래스 변수로 선언
	private static char[] row;//*얘도
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			nodeCount = sc.nextInt();
			String blank = sc.nextLine();// *엔터하고 원하는 값의 줄을 받아야하니까. 첫줄 뒤에 공백 없애기

			row = new char[nodeCount + 1];// 1부터 값을 넣으려면 배열의 크기가 주어진 숫자보다 하나 더 많아야 함.
			
			for (int i = 1; i <= nodeCount; i++) {// nodeCount랑 동일한 숫자를 인덱스로 사용해도 됨.

				String word = sc.nextLine();// 일단 네가지 정보 다 주는 라인 받기
				StringTokenizer cut = new StringTokenizer(word);// *네가지 주는 정보를 공백기준으로 하나씩 잘라서 생각할거다.

				cut.nextToken();// *처음으로 오는 숫자 버리기
				row[i] = cut.nextToken().charAt(0);// 그냥 오는걸 받기만 해도 되는데 내가 만든 배열의 자료형이 char이라서 맞춰주려는거야.
				// *뒤에 들어오는 숫자 2개를 안 받아도 되는 이유는 이미 완전 이진 트리라는 걸 알기 때문에 부모 자식의 관계를 안다.

			}
			
			System.out.println("#"+tc+" ");
			inorder(1);//루트의 정점번호는 매번 1
			System.out.println();

		} // 테케 반복 끝

	}//메인함수 끝
	
	private static void inorder(int i) {
		if(i<=nodeCount) {
			inorder(i*2);//왼쪽 자식
			System.out.print(row[i]);//n
			inorder(i*2+1);//오른쪽 자식
		}
	}
}
