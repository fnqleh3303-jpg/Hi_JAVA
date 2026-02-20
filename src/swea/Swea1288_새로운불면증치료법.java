package swea;

import java.util.Scanner;

public class Swea1288_새로운불면증치료법{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for(int tc=1;tc<=T;tc++){
        int[] counting = new int[10];//일단 카운팅 할 

        int n= sc.nextInt();
        int i=1;
        int number =0;
       
        
       while(true){
        number = n*i;//구구단으로 
        

        String s = String.valueOf(number);//*여기서 int를 string으로 변환
        for(int k=0;k<s.length();k++){//s를 한 글자씩 탐색
            int tmp = s.charAt(k)-'0';//*한 글자를 tmp변수에 담기. 아스키 이용해서 int로 
                counting[tmp]++;//해당 문자
            }
        
        
        boolean isFull = true;
        for(int val:counting){//*for문에서 하나하나 탐색 안하고 이렇게 도는 법
            if(val==0){
                isFull=false;
                break;//*얘는 for문을 나가는 brake
            }
            //배열을 다 돌았는데 모든 값이 0이 아니라면 만족. 
        }
        if(isFull){
            break;//*while문에서 break를 쓴다면 가장 가까운 반복문이 하나 나가는거다. 
            //그래서 이 break는 while문을 나가는 장치
        }
        i++;//n에 다가 하나씩 증가시키면서 곱하기//while문은 가장 마지막에 ++을 하는게 관례
    }
    
        System.out.println("#"+tc+" "+number);
       }
       sc.close();
    }
}
    


