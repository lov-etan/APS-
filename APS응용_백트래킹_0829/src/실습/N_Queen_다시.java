package 실습;

import java.util.Scanner;

public class N_Queen_다시 {
	static int N;
	static int[] iRow_vCol;
	static int cnt;
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<= T; tc++) {
			N = sc.nextInt(); //N*N의 배열에서 N개의 퀸 배치하기 
			
			iRow_vCol = new int[N];
			cnt = 0;
			queenPlacing(0);
			
			System.out.println("#" + tc + " " + cnt);
			
		}
	}
	
	static void queenPlacing(int row) {
		//재귀조건 
		if(row==N) {
			cnt++;
			return;
		}
		
		//재귀함수 
		for(int col=0; col<N; col++) {
			//만약 조건을 만족하면 
			if(isOk(row, col)) {
				iRow_vCol[row] = col;
				queenPlacing(row+1);
			}
		}
	}
	
	static boolean isOk(int row, int col) {
		for( int i=0; i<row; i++) { //현재 진행되고 있는 행까지 가능, 불가능 판별 
			if(iRow_vCol[i] == col || Math.abs(iRow_vCol[i]-col) == Math.abs(i-row)) {
				return false;
			}
		}
		return true;
	}

}
