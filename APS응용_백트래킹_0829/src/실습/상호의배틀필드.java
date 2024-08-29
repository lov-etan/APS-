package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드 {
	static int carR;
	static int carC;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			char[][] map = new char[R][C];
			
			for(int i=0; i<R; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<C; j++) {
					map[i][j] = st.nextToken().charAt(0);
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						carR = i;
						carC = j;
					}
				}
			}
			
			//input 받기 
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				//어떤 함수에 input 넣기 시작
				char input = st.nextToken().charAt(i);
				playGame(input);
			}
			
		}//tc
		
	}//main
	
	static void playGame(char input) {
		if(input == 'U') {
			
		} else if( input == 'D') {
			
		} else if (input == 'L') {
			
		} else if(input == 'R') {
			
		} else { //S - 포탄 발사 @!!
			
		}
	}

}
