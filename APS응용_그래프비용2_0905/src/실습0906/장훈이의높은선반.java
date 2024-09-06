package 실습0906;

import java.util.Scanner;

public class 장훈이의높은선반 {
	static int N, B;
	static int[] ehR;
	static int minSum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			//System.out.println(B);
			ehR = new int[N]; //직원의 키 배열 
			
			for(int i=0 ; i<N; i++) {
				ehR[i] = sc.nextInt(); //N개의 점원들의 키
			}
			
		
			minSum = Integer.MAX_VALUE; //min 값은 큰 수로 초기화!!!!
			dfs(0, 0);
			
			int ans = minSum - B;
			
			System.out.println("#" + tc + " " + ans);
			
		}//tc
		
	}//main
	
//	static void combination(int cnt, int sum) {
//		//기저조건
//		//모든 인원 다 검사했으면 
//		if(cnt == N) { Sidx == N <- 모든 걸 다 뽑았을 때 
//			//근데 sum이 B는 같거나 넘니?
//			if(sum >= B) {
//				minSum = Math.min(minSum, sum);
//			}
//			return;
//		}
//
//		
//		//재귀함수 
//		for(int pick=idx; pick<N; pick++) {
//			if(!visited[pick]) {
//				visited[pick] = true; //방문처리
//				combination(pick+1, sum+ehR[pick]);
//				visited[pick] = false; //방문 닫아주기 
	
//			}
//		}
//	}
//	
	static void dfs(int idx, int total) {
		if(idx == N) {
			if(total>=B) {
				minSum = Math.min(minSum, total);
			}
			return;
			
		}
		//부분집합
		dfs(idx+1, total + ehR[idx]);
		dfs(idx+1, total);
	}
}
