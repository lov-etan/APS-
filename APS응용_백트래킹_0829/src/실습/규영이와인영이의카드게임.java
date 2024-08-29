package 실습;

import java.util.Arrays;
import java.util.Scanner;

public class 규영이와인영이의카드게임 {
	static int[] kyuR;
	static int[] inR;
	static boolean[] visited;
	static int[] sel;
	static int kScore;
	static int iScore;
	static int winningCnt;
	static int cnt;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			boolean[] nums18 = new boolean[18];
			kyuR = new int[9];
			inR = new int[9];

			sel = new int[9];
			visited = new boolean[9];

			// 규영 카드 - 순서 고정
			for (int i = 0; i < 9; i++) {
				kyuR[i] = sc.nextInt(); // 규영 나온 숫자 1
				nums18[kyuR[i] - 1] = true; // 18개 원소 중 나온 숫자 체크 0인덱스 체크
			}
			// System.out.println(Arrays.toString(nums18));

			// 인영 카드 - 순열 9!
			int idx = 0;
			for (int i = 0; i < 18; i++) {
				if (!nums18[i]) { // 0인덱스 체크 됨 pass //1인덱스 체크 안 됨 2 저장
					inR[idx++] = i + 1;
				}
			}
//			System.out.println(Arrays.toString(inR));

			// ----- 규영 인영 카드 준비 완료
			// 구하고자 하는 것: 규영이가 이기는 경우/ 지는 경우
			cnt = 0;
			winningCnt = 0;
			// 인영이의 카드 순열 뽑아보기
			permutation(0);
			
			int win = winningCnt;
			int lose = cnt - winningCnt;

			System.out.println("#" + tc + " " + win + " " + lose);

		} // tc
	}// main

	static void permutation(int Sidx) {
		// 기저조건
		if (Sidx == 9) {// sel에 인영이의 순열 카드가 있는 상태임
			cnt++;
			//System.out.println(Arrays.toString(sel));
			// 하나씩 뽑으면서 규영이랑 대결하자!
			kScore = 0;
			iScore = 0;
			for (int i = 0; i < 9; i++) {
				fight(i);
			} // 끝나면 각자 스코어가 나온 상황

			// 규영이가 이긴 경우
			if (kScore > iScore) {
				winningCnt++;
			}
			return;
		}

		// 재귀함수
		for (int pick = 0; pick < 9; pick++) {
			if (!visited[pick]) {
				sel[Sidx] = inR[pick];
				visited[pick] = true;
				permutation(Sidx + 1);
				visited[pick] = false;
			}
		}
	}

	static void fight(int i) {
		if (kyuR[i] > sel[i]) {
			kScore += kyuR[i] + sel[i];
		} else {
			iScore += kyuR[i] + sel[i];
		}
	}

}
