package 수업;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 그래프탐색02_BFS {
	static String input = "7 9\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "1 6\r\n"
			+ "2 4\r\n"
			+ "2 7\r\n"
			+ "3 4\r\n"
			+ "4 7\r\n"
			+ "5 6\r\n"
			+ "5 7";
	
	static int V; //정점의 개수
	static int E; //간선의 개수 
	static List<Integer>[] adj; //인접리스트
	static boolean[] visited; //방문췍!
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
				
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V+1]; //배열만 만든거고 안에 리스트를 생성하지는 X
		for(int i=1; i<=V; i++) { //1번 정점부터 시작을 하니까
			adj[i] = new ArrayList<>();
			visited = new boolean[V+1];
		}
		visited = new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A].add(B);
			adj[B].add(A);//무향이니까
		}//간선 입력 완료
		
		bfs(1);
	}//main
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v); //시작점을 큐에 넣는다.
		visited[v] = true; //시작 정점을 방문책
		
		//큐가 공백상태가 될 때까지 돌겠다.
		//큐가 공백상태가 아니면 돌겠다. 
		while(!q.isEmpty()) {
			int curr = q.poll(); //정점 하나를 꺼낼거야
			System.out.println(curr);
			
			//curr에 인접하면서 방문하지 않은 친구들을 방문할거야
			for(int w: adj[curr]) {
				if(!visited[w]) {
					q.add(w);
					visited[w] = true;
				}
			}
			
//			for(int i=0; i<adj[curr].size(); i++) {
//				int w = adj[curr].get(i);
//			}
		}
		
	}

}
