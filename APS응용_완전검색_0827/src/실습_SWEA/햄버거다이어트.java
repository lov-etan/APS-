package 실습_SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 햄버거다이어트 {
	static int[][] 재료;
	static boolean[] sel; // 선택된 재료가 나타나는 배열 
	static int N; //재료의 개수	
	static int L;
	static int maxScore;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for( int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //재료의 개수
			L = sc.nextInt(); //최대 칼로리 
			
			재료 = new int[N][2]; //재료 배열
			sel = new boolean[N];
			for(int r=0; r<N; r++) { //각 행은 재료 정보 [c0 재료 점수, c1 최대 칼로리] 담고있음
				for(int c=0; c<2; c++) {
					재료[r][c] = sc.nextInt();
				}
			}
			maxScore = 0;  //초기화!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			powerset(0); //->결과값 maxScore 나타나게 됨
			
			System.out.println("#" + tc + " " + maxScore);
			
			 
			
		}//테스트케이스 끝 
	}
	
	static void powerset(int i) { //i는 재료 배열의 row 인덱스를 의미한다. 
		//기저조건
		if(i == N) {
			//System.out.println(Arrays.toString(sel));
			
			int score = 0;
			int calorie =0 ;
			//sel 한 바퀴 돌면서 값 계산하기
			for(int k=0; k<N; k++) { 
				if(sel[k]) { //만약 sel에 1값이 있다면,
					//점수와 칼로리를 계산한다.
					calorie += 재료[k][1];
					score += 재료[k][0];
				}
			}
			//System.out.println("S" + score);
			//System.out.println("c" + calorie);
			
			//칼로리 리밋 체크!
			if(calorie <= L) {
				maxScore = Math.max(score, maxScore);
			}
			
			return; //return!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		
		//재귀함수 
		sel[i] = true;
		powerset(i+1);
		sel[i] = false;
		powerset(i+1);
		
	}

}


//다른 방법:
//재귀함수 돌 때마다 칼로리 더해주기 (int sum)
//sum - 칼로리리밋 >= 0 : ㄱㄱ
//sum - 칼로리리밋 < 0 : break;