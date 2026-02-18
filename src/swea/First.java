package swea;
import java.util.Scanner;

public class First {
	public static void main(String[] args) {
		System.out.print("숫자를 입력 >>");
		Scanner sc = new Scanner(System.in);
		//입력받.
		int n = sc.nextInt();
		int sum = 0;
		for(int i=1;i<=n;i++) {
			if(i%2==0) {
				sum += i;
			}
		}
		System.out.printf("1부터 %d까지 수 중 짝수의 합 = %d", n, sum);
		sc.close();
	}
}
