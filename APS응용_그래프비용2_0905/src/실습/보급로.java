package 실습;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 보급로 {
	static class Node{
		int V;
		int W;
		
		public Node(int v, int w) {
			this.V = v;
			this.W = w;
		}
		
		public int getW() {
			return this.W;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N,E;
	static int[][] adjArr; //인접행렬
	static int[] D; //각 정점별 최단 거리 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //배열의 크기이자 정점의 수 
			
			//정점(인덱스) 간 가중치가 모아져있다. 
			adjArr = new int[N][N];
			for(int r=0; r<N; r++) {
				String str = sc.next();
				for(int c=0; c<N; c++) {
					adjArr[r][c] = str.charAt(c)-'0' ;
				}
			}
			
			
			
			//int[] p = new int[N];
			D = new int [N]; //간선의 최소 가중치 모음
			Arrays.fill(D, INF); //D[] 내부 값을 최대로 채워넣기 
			
			//다잌스트라 알고리즘 수행
			dijkstra(0); //시작 정점 0부터 시작 
			
			
			
			
		}//tc
		
	}//main
	
	static void dijkstra(int start) {
		//방문 여부 확인 배열
		//방문 췍!!
		boolean[] visited = new boolean[N];
		
		//시작 정점 노드 거리 초기화 
		D[0] = 0; //시작 정점까지의 거리 - 시작점은 0 
		
		//우선순위큐 사용 (시작점으로 부터의 거리가 작은 순대로 정렬하는 정점,가중치 노드 모아놓기)
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getW));
		pq.add(new Node(start, 0)); //시작 정점을 큐에 넣음 
		
		
		int currV = start;
		int nextV = start; //이거 초기화 뭘로 해야 할지 모르겠네.. 
		
		//원하는 지점에 도달할 때까지 돌기 시작 
		while(currV != N-1 || nextV != N-1) { //둘 다 N-1이면 멈추기 
			Node current = pq.poll();
			currV = current.V;
			int currW = current.W;
			
			if(visited[currV]) continue;
			
			//방문되지 않은 것 즉, 아직 뽑히지 않은 것이라면 
			visited[currV] = true; //뽑기!
			
			//현재 노드에서 연결된 다른 애들 탐색하기 
			
			
		}
	}
	
	
}
