package 실습;

import java.util.Scanner;

public class N_Queen {
	static int N;
	static int[] colStorage; // 각 행의 어떤 위치에 저장되어 있는지를 저장한다.
	// colStorage의 0 인덱스 : 0번째 행에서 말이 놓인 위치
	static int cnt;
	static boolean[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // N개의 퀸을 N*N 보드에 넣는다.

			arr = new boolean[N][N];
			colStorage = new int[N]; // [ , , , ]

			placeQueen(0); // 순열 돌리기

		}

	}

	static void 
		
		
	

}
