package 수업;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//V, E의 개수를 준다.
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		List<Integer>[] adjList = new ArrayList[V];
		
		//기본적으로 전부 생성을 해주어야 널포인트 익셉숀이 뜨지 않는다!
		for(int i=0; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			//가중치를 같이 저장하고 싶다면 1. 클래스를 정의해서 넣던지, 2.int[] 이용
			adjList[A].add(B);
			adjList[B].add(A);
		}
		
		
		//인접행렬 vs 인접리스트 (장단점 정도 알고 있자!!)
		// 둘 중 하나는 무조건 알고 있자!!
		
	}

}
