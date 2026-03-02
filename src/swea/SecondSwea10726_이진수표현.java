package swea;

import java.util.Scanner;

public class SecondSwea10726_이진수표현 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	
	for(int tc=1;tc<=T;tc++) {
		int N= sc.nextInt();
		int M = sc.nextInt();
		
		int mask = (1<<N) -1;//딱 뒤에서 n자리수 만큼만 1로 만들어서 mask에 넣는다.
		
		if((M & mask) == mask){//숫자는 적는 순간 컴퓨터는 진수로 인식하고 있어서 딱히 바꿔줄 필요가 없다. 
			System.out.println("#" + tc+ " "+ "ON");
		} else {
			System.out.println("#" + tc + " "+ "OFF");
		}
		
	}
	
}

}//클래스 끝

//6시 42분
