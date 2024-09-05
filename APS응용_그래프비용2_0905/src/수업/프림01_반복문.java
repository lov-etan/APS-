package 수업;

import java.util.Arrays;
import java.util.Scanner;

public class 프림01_반복문 {
	
	static final int INF = Integer.MAX_VALUE; //가중치 초기 무제한
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); //정점의 번호 0번부터 시작
		int E = sc.nextInt(); //간선의 수 
		
		//인접행렬 방식으로
		int[][] adjArr = new int [V][V];
		
		for(int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B= sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = W; //무행
		}
		
		//방문췍!
		boolean[] visited = new boolean[V];
		int[] p = new int[V]; //내 부모는... 사용하지 않을 거라면 굳이 작성하지 않아도 ok
		int[] dist = new int[V]; //아까 key라고 표현했던 선택한 간선의 가중치 
		
		//프림 제 1장: 초기화!
		for(int i=0; i<V; i++) {
			p[i] = -1; //0번 정도 사용하니까..
			dist[i] = INF;
		}
		
//		Arrays.fill(dist, INF);
		
		//프림 제 2장: 시작정점을 결정
		dist[0] = 0;
		
		//int ans = 0;
		
		//프림 제 3장: 가중치 배열을 돌면서 가장 값이 낮은 것을 골라 방문췍! / 갱신할 수 있으면 전부 갱신
		for( int i=0; i<V-1; i++) { //V번 돌아도 괜찮아~~
			
			int min = INF;
			int idx = -1; //건드리지 않은 값
			//[ ]방문하지 않았으면서 가중치 가장 작은 값 가져와
			for(int j=0; j<V; j++) { //어떤 정점을 뽑아볼까요~~~~
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j; 
				}
			}//해당 반복문이 종료가 되면.... idx = 이번에 뽑은 친구가 됨( 가장 작은 가중치를 가진 정점_방문x상태)
			visited[idx] = true;
			//ans += dist[idx]; <- 이러면 무조건 반복문 V번 돌아야 해
			
			//[ ]방문하지 않았고 갱신할 수 있으면 갱신해 (idx)
			for(int j=0; j<V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j]>adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx; //필요시
				}
			}
			
		}//끝
		
		int ans = 0;
		for(int i = 0; i<V; i++) {
			ans += dist[i];
		}
		
		System.out.println(ans);
		
		
		
		
		
		
	}
	
	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51\r\n"
			+ "";

}
