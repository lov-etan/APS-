package 수업;

import java.util.Scanner;

public class 그래프_01_인접행렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//V,E의 개수를 준다. 
		int V = sc.nextInt(); //정점의 개수 (0 or 1로 시작을 한다. - 문제 유의해서 볼 것)
		int E = sc.nextInt(); //간선의 갯수
		//간선의 개수 주는 방법
		//1. E개의 줄에
		//2. 다음 줄에 간선이 주어진다. 1 2 4 5 7 8 (두개씩 끊어서 입력을 받아야 함)
		
		int[][] adjArr = new int[V][V]; //만약 시작정점이 1이라면 [V+1][V+1]
		
		for(int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();//두 개의 정점이 주어진다.
			int W = sc.nextInt();//가중치가 있다면 값은 3개 
			
			adjArr[A][B] = 1; //가중치가 없다면 1을 있다면 W 저장하겠다. 
			//현재로서는 A -> B만 연결한 것임 '유향'
			adjArr[B][A] = 1;// 만약에 무향이라면 반대의 경우도 같이 작성을 해주어야 함
//			adjArr[A][B] = adjArr[B][A] = W; // 한줄 작성.  둘 다 1 넣고싶으니까.
			
			//만약에 유향그래프다. 가중치도 있어! 그리고 나는 변수를 잘 쓰고 싶지 않아...
//			adjArr[sc.nextInt()][sc.nextInt()] = sc.nextInt();
			
			
			
		}//E개의 간선을 입력 받을 반복문 
	}

}
