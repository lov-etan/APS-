package 실습;

import java.util.Scanner;

public class 쉬운거스름돈 {
	static int[] coins = {10, 50, 100, 500, 1000, 5000, 10000, 50000 };
	//cnts { 몇 개 , 몇 개, 몇 개, 몇 개, 몇 개} - 이것의 총계가 제일 작아야 함 
	static int[] cnts; //여기다 몇 개 넣었는지 넣어줘야지~

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 어차피 10단위니까 10으로 나눠줌
			
			//dp[tmpPrice]은 tmpPrice 금액을 만들기 위한 최소 동전 개수
			int[] dp = new int[N+1]; 
			
			//DP 테이블 초기화 
			for(int i=1; i<=N; i++) {
				dp[i] = 987654321; //초기화: 큰 값으로 설정 
			}
			
			//첫 번째 칸은 0 (0원을 만드는데 필요한 동전 개수는 0개)
			dp[0] = 0;

			//DP 점화식 채우기 
			for(int pick=0; pick<8; pick++) {
				for(int tmpPrice = coins[pick]; tmpPrice <=N; tmpPrice++) { //동전을 사용할 수 있을 때 시작 (tmpPrice가 적어도 pick(동전의값)보단 커야지)
						dp[tmpPrice] = Math.min(dp[tmpPrice], dp[tmpPrice - coins[pick]]+1); //최소 동전 개수 갱신 
				}
			}
			
			cnts = new int[8];
			
			//역추적 시작 (선택된 동전 확인)
			int tmpPrice = N; //총 금액부터 다시 되돌아가는 임시 가격 
			for(int pick = 7; pick>0; pick--) { //인덱스 범위 체크 조심 //큰 동전부터 확인 
				//업데이트 된 시점으로 돌 아 가 기~ i'm your butterfly 
				while(tmpPrice >= coins[pick] && dp[tmpPrice] == dp[tmpPrice - coins[pick]] + 1) {
					cnts[pick]++;
					tmpPrice -= coins[pick];
				}
			}
			
			// 결과 출력
            System.out.println("#" + tc);
            for (int i = 7; i >= 0; i--) { // 모든 동전 사용 개수 출력
                System.out.print(cnts[i] + " ");
            }
            System.out.println(); // 줄 바꿈
        }
			 
	}

}
