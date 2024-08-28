package 실습;

import java.util.Scanner;

public class 거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int t = sc.nextInt();//테스트 케이스 번호 
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
//			pow(N,M);
			System.out.println("#" + t+ " " + pow(N,M));
		}
	}
	
	static int pow(int N, int M) {
		//기저조건
		if(M==1) return N;
		
		//재귀함수 
		if(M%2 == 0) {
			int tmp = pow(N, M/2);
			return tmp*tmp;
		} else {
			int tmp = pow(N, (M-1)/2);
			return tmp*tmp*N;
		}
	}

}
