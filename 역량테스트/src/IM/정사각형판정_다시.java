package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형판정_다시 {
	static int N;
	static char[][] map;
	static int startR, startC;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N]; 
			startR = -1; 
			startC = -1;
			
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c);
					if(startR == -1 && map[r][c] == '#') {//#이 시작하는 지점 저장하기  //start 값이 업데이트가 안되었고 그 자리 값이 #인 곳을 찾는다. 
						startR = r;
						startC = c;
					}
				}
			}//map 받아오기 완료 
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			if(isSquare()) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			
			System.out.println(sb);
			
			
			
		}
	}
	
	static boolean isSquare() {
		//가로 길이 구하기 
		int W = 0;
		for(int c=startC; c<N; c++) {
			if(map[startR][c] == '#') {
				W++;
			}
		}
		//세로 길이 구하기 
		int H = 0; 
		for(int r=startR; r<N; r++) {
			if(map[r][startC] == '#') {
				H++;
			}
		}
		//가로 세로 길이가 같아야 함 (아니면 false) //정사각형은 네변의 길이가 모두 같다 
		if(W != H) return false;
		
		//이제 해당 범위 안이 모드 #으로 가득차있는지가 궁금하다. 
		for(int r=startR; r<startR+W; r++) {
			for(int c=startC; c<startC+H; c++) {
				if(map[r][c] != '#') return false; //하나라도 .이 나온다면 out
			}
		}
		
		///이제 가로세로, 해당 범위 안이 다 가득찼는지는 확인이 되었다.
		//근데 이 범위 밖에 #이 존재하면 안된다. 
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(r>=startR && r<startR+W && c>=startC && c<startC+H) continue;
				if(map[r][c] == '#') return false; //다른 범위에서 #이 등장한다면 false
			}
		}
		
		return true; //여기까지 통과한 당신,, yes 드리겠습니다. 
		
		
		
	}

}
