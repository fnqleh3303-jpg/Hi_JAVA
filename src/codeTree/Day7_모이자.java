package codeTree;

import java.util.Scanner;

public class Day7_모이자 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}//배열 a에 입력받는 값 할당 완료
		
		int min = Integer.MAX_VALUE;//min값은 갱신할 필요 없음. //*way를 다 더하는거기 떄문에 그냥 가장 큰 값을 넣는게 좋다. 
		
		for(int i=0;i<a.length;i++) {//일단은 어느 집에서 모일지 돌려
			
			int way=0;//돌면서 way가 계속 초기화 되야됨. 
			
			for(int j=0;j<a.length;j++) {//모이는 장소가 정해졌을때 사람의 이동 수 way에 담기
				way += Math.abs(j-i)*a[j];//*지금 달라지는 걸 곱해야지!
			}
			
			if(way<min) {//그 중에서 min갱신하기
				min = way;
			}
			
		}
		System.out.println(min);

	}
}
