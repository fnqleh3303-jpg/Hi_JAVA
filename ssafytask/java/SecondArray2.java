package grammer;

public class SecondArray2 {
	public static void main(String[] args) {
		int [][]array = {
				{2, 3, 1, 4},
				{8, 13, 3, 33},
				{7, 4, 5, 80}, 
				{17, 9, 11, 5}
		};
		int max = 0;
		int[]dr = {-1, 1, 0, 0};
		int[]dc = {0, 0, -1, 1};
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length;j++) {
				int sum = array[i][j];//for문 안에서 sum을 초기화 해야지 누적되지 않고, 원하는대로 답 얻을 수 있음. 
				
				for(int k=0;k<4;k++) {
					int nr=i+dr[k];
					int nc=j+dc[k];
					
					if(nr>=0 && nr<array.length && nc>=0 && nc < array[i].length) {
						sum += array[nr][nc];
					}
				}
				if (sum>max) {
					max = sum;
				}
			}
		}
		System.out.println("가장시끄러운 소움크기:" +max);
	}
}
