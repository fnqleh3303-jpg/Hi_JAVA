package swea;

import java.util.LinkedList;
import java.util.Scanner;

public class Sweq1228_암호문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			LinkedList<Integer> original = new LinkedList<>();// 삽입, 삭제에 용이함.
			int n = sc.nextInt();//처음에 들어가는 암호문의 갯수

			for (int i = 0; i < n; i++) {//그 암호문을 original 링크드리스트에 넣기
				original.add(sc.nextInt());//*리스트에 받은 암호문 모두 넣기. add사용

			}
			
			int insertNum = sc.nextInt();// 명령어의 갯수

			for (int i = 0; i < insertNum; i++) {
				// linked리스트에 in
				String h = sc.next();// 어떻게 넣을까? = 삽입하라
				int x = sc.nextInt();
				int y = sc.nextInt();

				if (h.equals("I")) {
					for (int j = 0; j < y; j++) {

						original.add(x++, sc.nextInt());
					}
				}

			}
			System.out.print("#" + tc);
			for(int k=0;k<10;k++) {
				System.out.print(" "+original.get(k));
			}
			System.out.println();
		} // 테케 끝

	}

}
