package swea;

import java.util.Scanner;

public class Swea6782_현주가_좋아하는_제곱근_놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			long n = sc.nextLong();// *10의 12제곱까지 n이 들어갈 수 있으니까 long
			int count = 0;

			while (n != 2) {// n이 2가 되면 끝
				
				if (Math.sqrt(n) % 1 == 0) {// 루트 n이 정수라면
					count++;
					n = (long) Math.sqrt(n); // *어짜피 정수인거 확인하고 바꾸는거니까 casting으로 int변환하면 됨!

				} else {// *else가 없다면 한번에 count++을 두번하는 대참사 발생! n에 변화 1되면 1바퀴. 이렇게 해야 빈틈이 없지.
					//루트사이에 간격이 너무 넓어서 runtime error가 나서 
					long tmp =(long)Math.floor(Math.sqrt(n));//*제일 가까운 작은 정수 tmp
//					System.out.println(n);
					
					long nextN = tmp+1;
					long nextSquare = nextN * nextN;
					
					count += nextSquare-n;//*빼는건 원래 n을 빼야지
					n= nextSquare;

				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}
//3시 15분
