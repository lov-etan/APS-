package 실습_백준;

import java.util.Scanner;

public class N과M1 {
	static int N; //N까지의 자연수 
	static int M; //M개의 순열 
	static int[] sel; //선택된 수 
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		visited = new boolean[N];
		
		permutation(0);
		
	}
	
	static void permutation(int Si) { //Si 는 depth를 의미하기도 함 
		//기저조건
		if(Si == M) {
			for(int k=0; k<M; k++) {
				System.out.print(sel[k] + " ");
			}
			System.out.println();
			
			return;
			
		}
		
		//재귀함수 
		//visited 방문을 열었으면 그거 빼고 가야 해 - 방문한 경우에는 배열에 표시 
		for(int p=0; p<N; p++) {
			if(!visited[p]) {
				sel[Si] = p+1; //선택된 박스에 선택된 숫자 넣기 
				visited[p] = true;
				permutation(Si+1); //다음 칸으로 재귀 호출 //1번 방문이 열린 세계 돌아가기 
				visited[p] = false; //방문 닫기 //다른 차원으로 가야 하니까 //2번 방문이 제일 처음 열린 경우도 생각해야지 
			}
		}
	}
	

}
