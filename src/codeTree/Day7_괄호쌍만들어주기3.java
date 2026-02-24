package codeTree;

import java.util.Scanner;

public class Day7_괄호쌍만들어주기3 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] row = new int[str.length()];
        
        for(int k=0;k<str.length();k++) {
        	row[k]= str.charAt(k);
        }//row배열에 string한글자씩 할당 완.
        
        int count=0;
        
        for(int i=0;i<str.length();i++) {//*놀랍게도 for문이랑 if문 헷갈림
        	if(row[i]=='(') {
        		for(int j=i+1;j<str.length();j++) {
        			if(row[j]==')') {
        				count++;
        			}
        		}
        	}
        }
        System.out.println(count);
    }
}
