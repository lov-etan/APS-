package 실습_백준;

import java.util.Arrays;
import java.util.Scanner;

public class N과M5_순열 {
	static int N;
	static int M;
	static int[] Nr;
	static int[] sel;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		Nr = new int[N];
		sel = new int[M];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			Nr[i] = sc.nextInt();
		}
		
		Arrays.sort(Nr); //수열은 사전 순으로 증가하는 순서로 출력해야 한다.  
		
		permutation(0);
		
		
	}
	
	static void permutation(int Si) {
		//기저조건
		if(Si == M) {
			for(int i=0; i<M; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		//재귀함수 
		for(int pick=0; pick<N; pick++) {
			if(!visited[pick]) {
				sel[Si] = Nr[pick];
				visited[pick] = true;
				permutation(Si+1);
				visited[pick] = false;
			}
		}
	}

}
