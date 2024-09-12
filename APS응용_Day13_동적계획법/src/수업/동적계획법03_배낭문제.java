package 수업;

import java.util.Scanner;

public class 동적계획법03_배낭문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //물건의 개수
		int W = sc.nextInt(); //배낭의 무게는 W를 초과하지 말아야 한다. 
		
		//햄버거 다이어트 냄새가 살짝 난다. 
		int[] weights = new int[N+1]; // 5 4 6 3 
		int[] cost = new int[N+1];    // 10 40 30 50 
		
		for(int i=1; i<=N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		}
		//dp[pick][tmpW] :pick번째 물건까지 고려했을 때, tmpW의 무게를 가진 배낭에서 얻을 수 있는 최대 가치 
		int[][] dp = new int[N+1][W+1]; //i번째 물건까지 고려할거야
		
		//물건은 한개씩만 존재
		for(int pick=1; pick<=N; pick++) {
			//w는 임시무게 // 0 1 2 3 4 5 6 7 8 9 10 (최대 무게까지 하나씩 늘어남) 
			for(int tmpW=0; tmpW<=W; tmpW++) {
				//내가 고려할 물건의 무게가 임시무게보다 작다면 고민 
				if(weights[pick] <= tmpW) {  //임시무게 3kg이고 내 물건이 1kg 그럼 고민
					dp[pick][tmpW] = Math.max(dp[pick-1][tmpW], dp[pick-1][tmpW-weights[pick]]  +  cost[pick]);
												//(이전고른것-임시무게)의 가치 와 이전고른것-{(임시무게-지금무게) + (지금무게 가치)} 비교 
				}else { //임시무게 2kg이고 내 물건 5kg면 어차피 못 들어가니까 
					//아니라면 이전까지 고민한게 베스트 
					dp[pick][tmpW] = dp[pick-1][tmpW];
				}
			}
		}//물건 고려
		
		System.out.println(dp[N][W]);
		
	}

}
