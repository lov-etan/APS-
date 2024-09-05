package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수 {
	static int w;
	static int h;
	static boolean[][] visited;
	static int[][] map;
	static int cnt;
	// 팔방 검사
	static int[] dr = { -1, -1, -1, 0, +1, +1, +1, 0 };
	static int[] dc = { -1, 0, +1, +1, +1, 0, -1, -1 };
	

	static class pos { // 좌표를 저장할 Pos 클래스
		int x, y;

		pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String wh = br.readLine();
		while (!wh.equals("0 0")) { // 입력의 마지막 줄에 00 // 테스트 케이스 끝
			StringTokenizer st = new StringTokenizer(wh);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new int[h][w];
			for (int r = 0; r < h; r++) {
				String mapping = br.readLine();
				st = new StringTokenizer(mapping);
				for (int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// System.out.println(Arrays.deepToString(map));

			visited = new boolean[h][w]; // 방문했는지 안했는지 확인할 배열
			

			//bfs(0, 0); // 시작지점 찍어주기 섬 찾기 시작
			
			cnt = 0;//섬의 개수 세기
			//시작 지점 반복해서 찍어야겠는데? 
			for(int r=0; r<h; r++) {
				for(int c=0; c<w; c++) {
					bfs(r,c);
				}
			}
			System.out.println(cnt);

			wh = br.readLine();// 새로운 인풋 값 받을 준비
		}
	}// main

	static void bfs(int x, int y) {
		Queue<pos> queue = new LinkedList<>(); //탐색을 위한 큐 생성 
		if(!visited[x][y] && map[x][y] ==1) { //방문하지 않았고, map의 값이 1이면 bfs 진행 
			queue.add(new pos(x,y)); //시작 위치 초기 쿼리에 저장
			visited[x][y] = true; //이제 방문한 것으로 표시 
			
			while(!queue.isEmpty()) { //큐가 빌 때까지 반복하기 
				pos curr = queue.poll(); //현재 위치 큐에서 빼주기 
				
				//꺼낸 위치가 원하는 위치인가? -> 이건 지금 안 중요하다. 
				 
				//현재 위치에서 팔방향 이동 시도
				for(int d=0; d<8; d++) {
					int nx = curr.x + dr[d];
					int ny = curr.y + dc[d];
					
					//만약 그쪽 방향으로 이동이 가능하다면 
					if(nx>=0 && nx<h && ny>=0 && ny<w && !visited[nx][ny] && map[nx][ny] ==1) {
						visited[nx][ny] = true;
						queue.add(new pos(nx,ny));
					}
				}
				
				
			}
			//큐가 만약에 비었다면? 
			cnt++;
			return;
		}
		
		
		
	}

}
