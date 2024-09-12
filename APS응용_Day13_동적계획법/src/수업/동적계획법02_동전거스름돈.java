package 수업;

import java.util.Scanner;

public class 동적계획법02_동전거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt(); //해당 거스름돈의 최소 '동전 개수' 3개 
		int[] dp = new int[money+1]; //왜? 해당 인덱스가 차있으니까 '[1원, 4원, 6원]'
		
		// 1, 4, 6원을 고민하려고 한다. 
		for(int i=1; i<= money; i++) {
			int minCnt = 987654321;
			minCnt = Math.min(minCnt, dp[i-1] + 1); //이전 값 최소 동전에서 +1 한 개를 더한 것과 비교
			
			
			if(i>=4) minCnt = Math.min(minCnt,  dp[i-4]+1);
			if(i>=6) minCnt = Math.min(minCnt,  dp[i-6]+1);
			dp[i] = minCnt;
		}
		
		System.out.println(dp[money]);
	}

}
