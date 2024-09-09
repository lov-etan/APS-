package 실습;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 작업순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			//인접행렬 만들기 
			int[][] adjArr = new int[V+1][V+1];
			int[] degree = new int[V+1]; //연결차수 채워주기 
			
			for(int i=1; i<=E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				adjArr[A][B] = 1; //연결관계 만들어주기 //연결없는 애들은 0으로 채워져있을 것임 
				degree[B]++; //연결 받는 정점(들어오는 화살표) 수 cnt
			}
			
			//위상정렬 제 1장: degree[]가 0인 애들을 큐에 넣어라! (선행조건 필요없는 애들)
			Queue<Integer> queue = new LinkedList<>();
			
			 for(int i=1; i<=V; i++) {
				 if(degree[i] == 0) {
					 queue.add(i); 
				 }
			 }
			 
			 StringBuilder sb = new StringBuilder();
			 sb.append("#").append(tc).append(" ");
			 //위상정렬 제 2장: 큐가 빌 때까지 순서대로 나올 수 있는 애들 다 꺼내준다. 
			 while(!queue.isEmpty()) {
				 int curr = queue.poll(); //하나 꺼내주기 
				 sb.append(curr).append(" "); //꺼낸건 올려놓기 
				 
				 for(int next=1; next<=V; next++) {
					 //연결된거 있으려나?
					 if(adjArr[curr][next] == 1) {
						 //있으면 그거 연결 끊어주자
						 degree[next]--;
						 adjArr[curr][next] = 0; //없던 관계 만들기
						 
						 if(degree[next] == 0) {//선행조건이 모두 만족한 애들은 이제 나갈 자격이 됨
							 queue.add(next);
						 }
					 }
					 
				 }
				 
			 }
			
			System.out.println(sb);
			
		}
	}

}
