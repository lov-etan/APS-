package 실습_SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 요리사 {
	static int N; // 재료의 수
	static int R; // 조합의 수
	static int[][] Sr;
	static int[] sel;
	static int minDiff;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt(); // 재료의 수
			R = N / 2; // 재료들 중 N/2 개를 뽑을 예정
			minDiff = Integer.MAX_VALUE; //최소 차이 
			Sr = new int[N][N]; // 시너지 배열

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					Sr[r][c] = sc.nextInt();
				}
			}

			sel = new int[R];

			combination(0, 0);
			System.out.println("#" + tc + " " + minDiff);

		}
	}

	static void combination(int i, int Si) { // 조합의 인덱스 //선택된 자의 인덱스
		//기저조건 
		if (Si == R) { // 꽉 차면 return 해줄 차례
			//System.out.println(Arrays.toString(sel));
			
			boolean[] isA = new boolean[N];
			// sel[ , , ] 조합이 완성되면 각 시너지 더해주기
			int sumA = 0;
			for (int k = 0; k < R - 1; k++) {
				for (int j = k + 1; j < R; j++) {
					sumA += Sr[sel[k]][sel[j]];
					sumA += Sr[sel[j]][sel[k]];
					isA[sel[k]] = true;
					isA[sel[j]] = true;
				}
			}

			// B음식 조합 알기
			int sumB = 0;
			for (int k = 0; k < N - 1; k++) {
				if (!isA[k]) {
					for (int j = k + 1; j < N; j++) {
						if (!isA[j]) {
							sumB += Sr[k][j];
							sumB += Sr[j][k];
						}
					}
				}

			}
			 
			int diff = Math.abs(sumA - sumB);
			minDiff = Math.min(minDiff, diff);
			
			return;
		}//기저조건 끝 
		
		//재귀함수 
		for(int l=i; l<=N-R+Si ; l++) {
			sel[Si] = l; //sel 표 안에 선택된 인덱스를 넣고싶음. 
			combination(l+1,Si+1);
		}

	}

}
