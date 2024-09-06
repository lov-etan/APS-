package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보급로2 {
						//상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int INF = Integer.MAX_VALUE;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			//인접 행렬
			int[][] map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c)-'0';
				}
			}//인접행렬 채우기 끝 (각 정점별 가중치가 나와있음)
			
			int[][] minDis = new int[N][N]; //각 정점의 최소 가중치 길이를 저장할 예정 D[]와 동일
			//Arrays.fill(minDis, INF); //초기에는 최소 가중치 길이 다 INF
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					minDis[r][c] = INF;
				}
			}
			
			//방문 여부 체크 할 곳 만들기
			visited = new boolean[N][N];
			
			//복구 작업에 드는 시간이 가장 작은 경로의 복구 시간 //최종 결과값 
			int minCost = INF;
			
			//시작점은 0,0
			minDis[0][0] = 0; 
			
			//선택된 정점의 좌표
			int row=0;
			int col=0;
			
			while(true) {
				//복구 작업에 드는 시간이 가장 작은 경로의 복구 시간 //최종 결과값 
				minCost = INF; //매 반복마다 minCost 초기화 해주어야 한다고 함
				//돌면서 가장 작은 minDis[][] 가진 정점 선택하기 (방문 안 한 애들 중..)
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						if(!visited[r][c] && minCost > minDis[r][c]) {
							minCost = minDis[r][c];
							row = r;
							col = c;
						}
						
					}
				}
				
				
				if(row == N-1 && col == N-1) break;
				
				//당청! 선택되었습니다!
				visited[row][col] = true;
				
				//연결된 애들 찾기 
				for(int d=0; d<4; d++) {
					int nr = row + dr[d];
					int nc = col + dc[d];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] ) { //지금까지 비용 + 실제 가중치 = 
						if(minDis[nr][nc] > minCost + map[nr][nc]) { //INF > 0 + 실제가중치 
							minDis[nr][nc] = minCost+map[nr][nc]; //얘 선택할거야 
						}
					}
				}
				
			}//while
			
			System.out.println("#" + tc + " " + minCost);
		}//tc
		
	}

}
