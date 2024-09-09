package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠검증 {
	static int[][] map;
	static boolean[] nums9;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {//테케 
			
			map = new int[9][9];
			for(int r=0; r<9; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<9; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}//map 채우기 완료 
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			if(isCorrect()) {
				sb.append(1);
			} else {
				sb.append(0); 
			}
			
			System.out.println(sb);
			
		}
	}
	
	static boolean isCorrect() {
		//가로줄 숫자 안 겹치는지
		for(int r=0; r<9; r++) {
			nums9 = new boolean[9];
			for(int c=0; c<9; c++) {
				nums9[map[r][c]-1] = true;
			}
			if(!isOk()) return false; 
		}
		
		//세로줄 숫자 안 겹치는지 
		for(int c=0; c<9; c++) {
			nums9 = new boolean[9];
			for(int r=0; r<9; r++) {
				nums9[map[r][c]-1] = true;
			}
			if(!isOk()) return false;
		}
		
		//3*3칸 안 겹치는지 //시작점 잡아서 몇 개의 칸 검사하는 것 
		int row = 0; 
		int col = 0;
		for(int r=0; r<9; r+=3) { //시작점 퐁당퐁당 
			for(int c=0; c<9; c+=3) {
				//System.out.println(r + " " +  c);
				if(!is33Ok(r,c)) return false;
			}
		}
		
		//이걸 다 거쳤다면 true
		return true; 
		
		
//		//시작점 넘기면 그로부터 3*3행 탐색//시작점 잘못 선택함 !!!!! 이렇게 되면 (0,0) (3,3) (6,6) 이렇게 건너뛰게 된다!
//		while(row<9 && col<9) {
//			nums9 = new boolean[9];
//			is33Ok(row, col); 
//			row += 3;
//			col += 3;
//		}
		
		
	}
	
	
	
	static boolean isOk() { //nums9 불리언 배열이 모두 true가 되어있어야 한다. 
		for(int i=0; i<9; i++) {
			if(!nums9[i]) return false; //하나라도 false라면? 땡!
		}
		return true;
	}
	
	static boolean is33Ok(int row, int col) {
		//시작점으로부터 가로3, 세로3을 거쳐가며 해당 숫자를 불리언9배열에다가 찍는다. 
		nums9 = new boolean[9]; //초기화 안해줬네....
		for(int r=0; r<3; r++) {
			for(int c=0; c<3; c++) {
				nums9[map[row+r][col+c]-1] = true;
			}
		}
		if(!isOk()) { //만약 모든 숫자가 true가 되어있지 않다면 false를 반환한다. 
			return false;
		}
		
		return true; //
	}


}
