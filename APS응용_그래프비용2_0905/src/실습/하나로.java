package 실습;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 하나로 {
	
	static class Edge{
		int A;
		int B;
		long W;
		
		public Edge(int A, int B, long W) {
			this.A = A;
			this.B = B;
			this.W = W;
		}
		
		public long getW() {
			return this.W;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //정점의 개수 
			
			int[] xR = new int[N+1];
			int[] yR = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				xR[i] = sc.nextInt();
			}
			
			for(int i=1; i<=N; i++) {
				yR[i] = sc.nextInt();
			}
			
			
			double E = sc.nextDouble(); //환경 부담 세율 
			
			//정점을 다루기 때문에 인접 리스트가 필요함 
			List<Edge>[] adjArr = new ArrayList[N+1];
			
			for(int i=1; i<=N; i++) {
				adjArr[i] = new ArrayList<>();
			}
			
			for(int i=1; i<=N-1; i++) {
				//시작, 끝, 가중치를 이뤄야 함 
				for(int j=i+1; j<=N; j++) {
					int A = i;
					int B = j;
					long W = (long) (Math.pow(xR[j]-xR[i],2) + Math.pow(yR[j]-yR[i],2));
					
					adjArr[A].add(new Edge(A, B, W));
					adjArr[B].add(new Edge(B, A, W)); ///여기 [B] !!!!!!!!!!!!
				}
				
				
			}// 입력 완료 
			
			//준비 - 최소신장트리 돌릴 준비 
			boolean[] visited = new boolean[N+1];
			PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(Edge::getW));
			
			//현재 선택한 시작 정점 = 1; //1을 방문했다고 처리해준다. 
			visited[1] = true;
			
			long minWs = 0; //최소 간선 가중치의 합  //이거 int형으로 잘못 썼더니 숫자 음수 나와!!!!
			int pick = 1; //지금 한 개 픽 했으니까 1개부터 고르기 시작 
			
			pq.addAll(adjArr[1]); //0 정점과 연결된 애들 싹 불러모아!! 리스트 싹 불러!! edge(A,B,W), edge(B,A,W), edge(A,C,W), edge(A,T,W)
			
			while(pick != N) { //N개의 정점 다 뽑을 때까지 while문 돌리기
				Edge e = pq.poll(); //간선 가중치 작은 애들부터 나오게 될 것이다~~
				if(visited[e.B]) continue; //A와 연결된 애가 이미 선택된 애라면 pass~
				
				//이미 선택된 애가 아니라면 
				visited[e.B] = true; //선택을 하고
				minWs += e.W; //간선 최소 가중치에다가 뽑은애랑의 가중치 넣어주고 
				pick++; //뽑은 개수 올려주기 
				
				pq.addAll(adjArr[e.B]); //뽑은 애와 연결된 애들 이제 다시 다 불러와!!
				
			}
			
			//이 과정 거치면 가장 작은 가중치만으로 이루어진 연결 관계가 완성되게 됨
			long cost = Math.round(E*minWs);
			
			System.out.println("#" + tc + " " + cost);
			
			
			
		}
	}

}
