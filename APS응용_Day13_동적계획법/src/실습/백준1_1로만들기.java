package 실습;

import java.util.Scanner;

public class 백준1_1로만들기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //이 숫자가 되어야 한다. 
		
		int[] dp = new int[N+1]; //N이 되면 멈출거야
		dp[1] = 0; //1을 만들기 위해서 할 수 있는 연산은 없어 
		
		for(int tmp=2; tmp<=N; tmp++) { //
			dp[tmp] = dp[tmp - 1] + 1;
			if(tmp%2 == 0) {
				dp[tmp] = Math.min(dp[tmp], dp[tmp/2] +1);
			}
			if(tmp%3 == 0) {
				dp[tmp] = Math.min(dp[tmp], dp[tmp/3] +1);
			}
		}
		
		System.out.println(dp[N]);
		
		
	}
}
