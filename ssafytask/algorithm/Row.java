import java.util.Scanner;

public class Row {
public static void main(Row[] args) {
	Scanner sc = new Scanner(System.in);
	
	for(int i=0;i<10;i++) {
		int tc = sc.nextInt();
		
		String target = sc.next();
		String word = sc.next();
		
		int index = 0;
		int count =0;
		
		while(true){
			index = word.indexOf(target, index);
			
			if(index != -1) {
				count++;
				index +=target.length();
			} else {
				break;
			}
		}
		System.out.println();
	}
}
}
