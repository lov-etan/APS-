package 실습;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈도둑 {
	static int N;
	static int maxCnt;
	static int cnt;
	static int[][] map;
	static boolean[][] visited;  //아~ 이거 있어야 조건 만족하는 것들 중에 갔던 곳 또 안 가는데!!!
	// 상 하 좌 우 
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	static class pos{
		int x, y;
		
		pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //치즈 한 변의 길이 
			
			map = new int[N][N];
			
			int maxDay = -1; //map 속 최대일자 저장 
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = sc.nextInt();
					maxDay = Math.max(maxDay, map[r][c]);
				}
			}
			
			maxCnt = 1;//가장 많은 치즈 덩어리 //day=0 일 때, 무조건 한 덩이부터 시작함
			for(int day=1; day<=maxDay; day++) {//x일이 지난 치즈 
				cnt = 0; //각 일자의 치즈 덩어리 
				visited = new boolean[N][N]; //간 적이 있는 곳 초기화
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						bfs(r,c,day); 
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
				
			}
			
		
			
			System.out.println("#" + tc + " " + maxCnt);
	
		}//tc
	}//main
	
	static void bfs(int x, int y, int day) {
		Queue<pos> queue = new LinkedList<>();
		if(map[x][y] > day && !visited[x][y]) { //해당 일자가 지난 치즈만 남아있다. 
			queue.add(new pos(x,y)); //시작점 저장해주기 
			visited[x][y] = true; //시작 위치 방문 처리 
			
			while(!queue.isEmpty()) { //큐가 빌 때까지 인접한 것들 세기 
				pos curr = queue.poll(); 
				
				//현재 위치에서 네 방향 이동 
				for(int d=0; d<4; d++) {
					int nr = curr.x + dr[d];
					int nc = curr.y + dc[d];
					
					//visited 까지 꼼꼼히 조건 달아주기!!!
					if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc] > day && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new pos(nr,nc));
					}
				}
				
			}
			cnt++; 
			return;
		}
		
		
		
	}

}
