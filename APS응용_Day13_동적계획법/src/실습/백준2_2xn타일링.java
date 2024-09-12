package 실습;

import java.util.Scanner;

public class 백준2_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =  sc.nextInt(); //1 또는 2의 합이 N이 되어야 한다. 
		
		int[] dp = new int[N+2]; //그 숫자를 1과 2의 조합 
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2; //N이 1이 들어오면 dp[2]는 없는 값이야. 근데 선언해버렸네? dp 배열 크기를 키워야 해
		
		for(int tmp=3; tmp<=N; tmp++) {
			dp[tmp] = (dp[tmp-1]+dp[tmp-2]) % 10007;
		}
		
		System.out.println(dp[N]);
			
	}

}
