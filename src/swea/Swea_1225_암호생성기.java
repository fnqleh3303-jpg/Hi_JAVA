package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for(int tc =0;tc<10;tc++) {
			int T =sc.nextInt();//주어지는 tc받기
			
			int[] row = new int[9];//자리 바꿔야하니까 크기 하나 더 큰 배열 생성
			
			for(int i=0;i<8;i++) {//일단 인덱스 0에서 8까지 돌면서 
				row[i] = sc.nextInt();//들어오는 숫자 할당
			}//할당 끝
			
//			System.out.println(Arrays.toString(row));
			
			int count=1;//점점 큰 숫자를 더해야하니까
			
			while(row[7]>0) {//인덱스 7번이 0이 되면 그 배열이 답이니까 while문 멈춰
				row[8] = row[0]-count;//일단 인덱스0 값을 count로 빼기해서 마지막 인덱스 8에 넣는다. 
				
				row[0] = row[1];
				row[1] = row[2];
				row[2] = row[3];
				row[3] = row[4];
				row[4] = row[5];
				row[5] = row[6];
				row[6] = row[7];
				row[7] = row[8];
				count++;
				if(count>5) count=1;//*count는 5까지 증가했다가 다시 1로 줄어들어야 한다. 문제 제대로 읽어라!!
				
			}//마지막 인덱스의 값이 0이 되면 while문 멈춤. 
			
//			System.out.println(row);
			if(row[7]<=0) {//0보다 작아도 0으로 간주.
				row[7] =0;
			}
			
			System.out.print("#"+T);
			for(int i=0;i<8;i++) {
				System.out.print(" "+ row[i]);
			}
			System.out.println();
			
		}//테케 반복 끝
	}
}
