package 실습;

import java.util.Scanner;

public class 쉬운거스름돈2 {
    static int[] coins = {10, 50, 100, 500, 1000, 5000, 10000, 50000}; // 동전 종류
    static int[] cnts; // 각 동전의 사용 개수를 저장할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수 입력

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 금액 입력
            cnts = new int[8]; // 동전 사용 개수 초기화

            // DP 배열 생성: dp[i]는 i 금액을 만들기 위한 최소 동전 개수
            int[] dp = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                dp[i] = 987654321; // 초기화: 큰 값으로 설정
            }

            // DP 점화식 채우기
            dp[0] = 0; // 0원을 만드는 데 필요한 동전 개수는 0개
            for (int pick = 0; pick < coins.length; pick++) { // 각 동전에 대해
                for (int tmpPrice = coins[pick]; tmpPrice <= N; tmpPrice++) { // 현재 동전을 사용할 수 있을 때
                    dp[tmpPrice] = Math.min(dp[tmpPrice], dp[tmpPrice - coins[pick]] + 1); // 최소 동전 개수 갱신
                }
            }

            // 역추적: 어떤 동전을 사용했는지 확인
            int tmpPrice = N; // 목표 금액부터 시작
            // 큰 동전부터 찾지 않고, DP 테이블에서 최적해를 추적
            while (tmpPrice > 0) {
                for (int pick = 0; pick < coins.length; pick++) { // 작은 동전부터 확인
                    if (tmpPrice >= coins[pick] && dp[tmpPrice] == dp[tmpPrice - coins[pick]] + 1) {
                        cnts[pick]++; // 해당 동전 사용 개수 증가
                        tmpPrice -= coins[pick]; // 금액 감소
                        break; // 현재 동전을 사용하고, 다시 처음부터 탐색
                    }
                }
            }

            // 결과 출력
            System.out.println("#" + tc);
            for (int i = 7; i >= 0; i--) { // 모든 동전 사용 개수 출력
                System.out.print(cnts[i] + " ");
            }
            System.out.println(); // 줄 바꿈
        }

        sc.close();
    }
}
