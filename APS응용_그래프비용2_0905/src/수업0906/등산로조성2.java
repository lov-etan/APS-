package 수업0906;

import java.util.Scanner;

public class 등산로조성2 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, K, maxH, ans; //N:2차원배열 크기, K 공사가능 깊이
	static int[][] mountain;
	static boolean[][] visited;//방문처리
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			maxH = 0; //지형의 높이는 1~20  더 작은 수로 초기화 해야 함
			ans = 0; //등산로 길이 = 0;
			mountain = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					mountain[i][j] = sc.nextInt();
					//높이만 찾는다.! 위치는 찾지 않는다. 
					if(maxH < mountain[i][j])
						maxH = mountain[i][j];
				}
			}//입력 받으면서 최대 높이만 찾을거야! 여러개 있을 수 있어서!!
			
			int ans = 0;
			
			//전체를 순회하면서 가장 높은 봉우리에서 등산로 조성을 시작!
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(mountain[i][j] == maxH) { //높이가 최대 높이와 같은 애가 있으면 바로 공사 시작하면 됨!
						//공사시작 
						work(i,j,mountain[i][j],1,true); 
					}
				}
			}
			
			
		}
	}
	
	//r,c : 현재 좌표
	//h: 현재 높이
	//dist : 지금까지의 공사 길이
	//skill: 공사를 할 수 있는가 없는가 
	//시작: 나 위치는 어디 있고 아직 시작이니까 길이는 1이고 나는 공사를 할 수 있는 능력을 가지고 있어
	private static void work(int r, int c, int h, int dist, boolean skill) {
		if(dist > ans) { //최대 길이가 궁금한거니까 갱신할 수 있으면 갱신!
			ans = dist; //
		}
		
		visited[r][c] = true;//방문 췍!!
		
		////////////////////////////////////
		//4방향 탐색을 해야겠다. (상하좌우 순으로 탐색하겠다)
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			//경계를 벗어났으면 쳐내/ 혹은 갈 수 없어도 쳐내!(이미 방문한 곳이라면)
			if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue; //그럼 나 안 가
			//괜찮으면
			//1. 다음 좌표의 높이가 내 높이 보다 낮아
			if(h> mountain[nr][nc])
				work(nr,nc,mountain[nr][nc], dist+1,skill); //공사할 수 있으니까 skill 내린 것임
			//2. 다음 좌표의 높이가 나와 같거나 높아!
			else if(skill && h > mountain[nr][nc] - K) {//아직 나 공사할 수 있어 && {
				
				work(nr,nc,mountain[r][c]-1 ,dist+1,false);
				
			}
		}
		
		visited[r][c] = false; //원상 복구
		
	}







































	static String input = "10\r\n"
			+ "5 1\r\n"
			+ "9 3 2 3 2\r\n"
			+ "6 3 1 7 5\r\n"
			+ "3 4 8 9 9\r\n"
			+ "2 3 7 7 7\r\n"
			+ "7 6 5 5 8\r\n"
			+ "3 2\r\n"
			+ "1 2 1\r\n"
			+ "2 1 2\r\n"
			+ "1 2 1\r\n"
			+ "5 2\r\n"
			+ "9 3 2 3 2\r\n"
			+ "6 3 1 7 5\r\n"
			+ "3 4 8 9 9\r\n"
			+ "2 3 7 7 7\r\n"
			+ "7 6 5 5 8\r\n"
			+ "4 4\r\n"
			+ "8 3 9 5\r\n"
			+ "4 6 8 5\r\n"
			+ "8 1 5 1\r\n"
			+ "4 9 5 5\r\n"
			+ "4 1\r\n"
			+ "6 6 1 7\r\n"
			+ "3 6 6 1\r\n"
			+ "2 4 2 4\r\n"
			+ "7 1 3 4\r\n"
			+ "5 5\r\n"
			+ "18 18 1 8 18\r\n"
			+ "17 7 2 7 2\r\n"
			+ "17 8 7 4 3\r\n"
			+ "17 9 6 5 16\r\n"
			+ "18 10 17 13 18\r\n"
			+ "6 4\r\n"
			+ "12 3 12 10 2 2\r\n"
			+ "13 7 13 3 11 6\r\n"
			+ "2 2 6 5 13 9\r\n"
			+ "1 12 5 4 10 5\r\n"
			+ "11 10 12 8 2 6\r\n"
			+ "13 13 7 4 11 7\r\n"
			+ "7 3\r\n"
			+ "16 10 14 14 15 14 14\r\n"
			+ "15 7 12 2 6 4 9\r\n"
			+ "10 4 11 4 6 1 1\r\n"
			+ "16 4 1 1 13 9 14\r\n"
			+ "3 12 16 14 8 13 9\r\n"
			+ "3 4 17 15 12 15 1\r\n"
			+ "6 6 13 6 6 17 12\r\n"
			+ "8 5\r\n"
			+ "2 3 4 5 4 3 2 1\r\n"
			+ "3 4 5 6 5 4 3 2\r\n"
			+ "4 5 6 7 6 5 4 3\r\n"
			+ "5 6 7 8 7 6 5 4\r\n"
			+ "6 7 8 9 8 7 6 5\r\n"
			+ "5 6 7 8 7 6 5 4\r\n"
			+ "4 5 6 7 6 5 4 3\r\n"
			+ "3 4 5 6 5 4 3 2\r\n"
			+ "8 2\r\n"
			+ "5 20 15 11 1 17 10 14\r\n"
			+ "1 1 11 16 1 14 7 5\r\n"
			+ "17 2 3 4 5 13 19 20\r\n"
			+ "6 18 5 16 6 7 8 5\r\n"
			+ "10 4 5 4 9 2 10 16\r\n"
			+ "2 7 16 5 8 9 10 11\r\n"
			+ "12 19 18 8 7 11 15 12\r\n"
			+ "1 20 18 17 16 15 14 13\r\n"
			+ "";
	

}
