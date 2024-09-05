package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 창용마을무리의개수 {
	static int[] p; //중간 대표자 //부모의 인덱스 번호를 기억함 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1]; //N명 1번~N번 
			
			for(int i=1; i<=N;i++) {
				p[i] = i; //처음에는 자기 자신이 대표자이다. 
			}
			
			
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b); //둘의 관계를 이어줌 
			}
			
			// 몇 개의 집합이 존재하는지 계산하라
			Set<Integer> set = new LinkedHashSet<>();
			
			for(int i=1; i<=N; i++) {
				set.add(findSet(i)); //최고 부모의 값을 set에 넣어줌 
				//findSet(i) == i -> cnt++
			}
			
			
			int res = set.size();
			
			System.out.println("#" + tc + " " + res);
			
		}
		
	}
	
	static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
	
	static int findSet(int a) {
		if(p[a] == a) { //본인이 대표자라면
			return a;
		} else { //본인이 대표자가 아니라면 
			p[a] = findSet(p[a]);
			return p[a];
		}
	}

}
