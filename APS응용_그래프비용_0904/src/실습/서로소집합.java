package 실습;

import java.util.Scanner;

public class 서로소집합 {
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int n = sc.nextInt(); //정점의 수 
			int m = sc.nextInt(); //연산의 개수 
			
			//정점 1부터 n까지 (그 크기는 n+1)
			p = new int[n+1];
			for(int x=1; x<=n; x++) { //초기 정점의 대표자는 모두 자기 자신이다. 
				p[x] = x;
			}
			
			System.out.print("#" + tc + " ");
			//연산의 개수 m 만큼 연산을 받아오기 시작
			for(int cal=0; cal<m; cal++) {
				int what = sc.nextInt(); // 0 이면 union / 1이면 대표자 같은지 확인
				int a = sc.nextInt();
				int b = sc.nextInt();
				if( what == 0) { //union
					union(a,b);
				} else { //대표자 같니? 
					if(findSet(a) == findSet(b)) { //findSet은 최종부모 p[a]는 중간부모!!!
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}
			}
			System.out.println(); //아.. 다음 테케도 고려하자....
			
		}
	}//main
	
	static void union(int a, int b) { //a집합에 b집합 넣을게 
		p[findSet(b)] = findSet(a); 
	}
	
	static int findSet(int a) { //하나하나 올라가는 중 그 정점을 이야기함. 결국에는 p[a]를 찾게 해주는 그 과정에 있다. 
		if( p[a] == a) {
			return a; //본인이 대표자이다
		}else { //본인이 대표자가 아닌 경우 
			//return p[findSet(a)]; //타고 타고 올라가는 중
			p[a] = findSet(p[a]);
			return p[a]; //중간 부모 값을 뚝뚝 끊어줌 타고타고 안 가고 return이니까 배열의 수가 직접 바뀌지는 않음
		}
	}

}
