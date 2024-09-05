package 실습;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 하나로 {
	static class Edge {
		int A;
		int B; //두 시작과 끝 정점
		long W; //가중치 
		
		public Edge(int a, int b, long w){
			this.A =a;
			this.B =b;
			this.W =w; 
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}
		
		//comparator 쓸 준비 
		public long getW() {
			return W;
		}

//		@Override
//		public long compareTo(Edge o) {
//			// TODO Auto-generated method stub
//			return (long)this.W - o.W;
//		}

		
	}
	
	static int[] p; //대표자 담을 배열 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); //섬의 개수
			
			//int[][] map = new int[2][N];
			
			int[] xr = new int[N]; //인덱스=정점 //정점별 x좌표
			int[] yr = new int[N]; //정점별 y좌표
			
			for(int i=0; i<N; i++) {
				xr[i] = sc.nextInt(); //정점의 x좌표
			}
			for(int i=0; i<N; i++) {
				yr[i] = sc.nextInt(); //정점의 y좌표
			}
			
			//가중치 
			//우선순위 큐! //크루스칼 1단계: 간선을 기준치 기준으로 정렬 // 자동으로 가중치가 작은 것부터 뽑아내게 됨
			PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(Edge::getW));
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					//두 개의 연결 관계 만들기 
					int A = i; //시작 정점
					int B = j; //끝 정점
					long W = (long) (Math.pow(xr[i]-xr[j], 2) + Math.pow(yr[i]-yr[j],2)); // 거리 제곱 
					Edge edge = new Edge(A,B,W);
					pq.add(edge);
				}
			}
			
			//크루스칼 제 2장: V-1개의 간선을 뽑아라! n-1개의 간선을 뽑으면 됨. 
			//대표자 설정
			p = new int[N];
			for(int i=0; i<N; i++) {
				p[i] = i; //처음 대표자는 자기자신이 될 것임 
			}
			
			long distance = 0;
			int pick = 0; //내가 뽑은 간선의 수
			
			//가중치 작은 것부터 union 시도 
			int pqSize = pq.size(); //간선의 개수 미리 저장 
			for(int i=0; i<pqSize; i++) { //큐가 빌 때까지 while로 돌린다. 
				Edge out = pq.poll();
				int x = out.A;
				int y = out.B; //정점 시작과 끝 뽑아주기 
				long w = out.W;
				
				//만약 두 정점의 부모가 같지 않다면, union 해주기
				int px = findSet(x);
				int py = findSet(y);
				
				if(px != py) { //만약에 부모가 다르다면, 
					 union(px, py);
					 distance += w; //연결되었으니 거리를 더해준다. 
					 pick++;
				}
				
				//사이클 모든 애들이 다 돌아야 stop. 중간에 사이클 돌면 큰일나!-어차피 다시 돌아가지 않게 for문 돌려서 정점 선택해둬서 사이클 도는 거
				if(pick == N-1) {
					break;
				}
			}//union 끝
			
			double E = sc.nextDouble(); //해저터널 건설의 환결 부담 세율 실수 0~1 : double
			long res = Math.round(E * distance);
			
			//최소 신장 트리를 이용하여 가장 최소한의 거리를 가는 distance를 구하게 됨 
			System.out.println("#" + tc + " " + res);
			
		}//tc
	}
	
	static void union(int A, int B) {
		p[findSet(B)] = findSet(A);
	}
	
	static int findSet(int a) {
		if(p[a] == a ) { //만약에 부모면?
			return a;
		} else {
			p[a] = findSet(p[a]); 
			return p[a];
		}
	}
	

}
