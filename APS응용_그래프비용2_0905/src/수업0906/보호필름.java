package 수업0906;

import java.util.Scanner;

public class 보호필름 {
	static int D,W,K; //D 행 1~13, W 열1~20, K: 통과기준1~D 
	static int[][] film; //보호필름 저장
	static int ans; //정답(최소 투약횟수) 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];
			
			for(int i=0; i<D; i++) {
				for(int j=0; j<W; j++) {
					film[i][j] = sc.nextInt();
				}
			}//보호입력 완료
			
			ans = K; //통과기준인 K만큼 쏠 수 있어!
			
			makefilm(0,0);
			
			System.out.println("#" + tc + " " + ans);
			
		}//tc
	}//main
	
	
	//idx: 현재 약을 주입하려고 하는 행
	//cnt: 약품을 주입한 횟수 
	private static void makefilm(int idx, int cnt) {
		if(idx == D) {
			//이제 확인을 하겠다!
			if(isOk())
				ans = Math.min(ans, cnt);
			return;
			
		}
		
		//1. 주입 X
		makefilm(idx+1, cnt);
		
		//원본 다시 갖다놓기
		int[] tmp = new int[W];
		for(int i=0; i<W; i++) {
			tmp[i] = film[idx][i];
		}
		
		//2. 주입 A
//		for(int i=0;i<W; i++) {
//			film[idx][i] = 0;
//		}
		yak(idx,0);
		makefilm(idx+1, cnt+1);
		
		//3. 주입 B
		for(int i=0; i<W; i++) {
			film[idx][i] = 1;
		} 
		yak(idx,1);
		makefilm(idx+1, cnt+1);
		
		//원상복구!
		for(int i=0; i<W; i++) {
			film[idx][i] = tmp[i];
		}
	}
	
	private static void yak(int r, int drug) {
		for(int i=0; i<W; i++) {
			film[r][i] = drug;
		}
	}
	
	//모든 열이 연속된 특성이 k개 이상 인가?
	private static boolean isOk() {
		//열을 고정시킨 상태에서 검사를 할거야
		for(int c=0; c<W; c++) {
			boolean flag = false;
			int cnt = 1;
			
			for(int r=1; r<D; r++) {
				if(film[r][c] == film[r-1][c]) cnt++; //이전과 나와 같다면 카운트
				else cnt = 1; //우린 연속된 친구가 필요하므로 다시 이 친구부터 세야 하므로 cnt는 다시 1이야
			
				if(cnt >= K) {
					flag = true;
					break;
				}
			}//해당 열검사 완료
			//열검사가 끝났는데 검사 결과 부적절 (당신은 보호필름이 될 수 없습니다) //해당 열이 통과하지 못했다. 이후는 볼 필요 없어. 
			if(!flag) return false;
		}//모든 열검사 완료 
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static String input = "10\r\n"
			+ "6 8 3\r\n"
			+ "0 0 1 0 1 0 0 1\r\n"
			+ "0 1 0 0 0 1 1 1\r\n"
			+ "0 1 1 1 0 0 0 0\r\n"
			+ "1 1 1 1 0 0 0 1\r\n"
			+ "0 1 1 0 1 0 0 1\r\n"
			+ "1 0 1 0 1 1 0 1\r\n"
			+ "6 8 3\r\n"
			+ "1 1 1 1 0 0 1 0\r\n"
			+ "0 0 1 1 0 1 0 1\r\n"
			+ "1 1 1 1 0 0 1 0\r\n"
			+ "1 1 1 0 0 1 1 0\r\n"
			+ "1 1 0 1 1 1 1 0\r\n"
			+ "1 1 1 0 0 1 1 0\r\n"
			+ "6 8 4\r\n"
			+ "1 1 0 0 0 1 1 0\r\n"
			+ "1 0 1 0 0 1 1 1\r\n"
			+ "0 1 0 0 1 1 0 0\r\n"
			+ "1 0 1 0 0 0 0 0\r\n"
			+ "1 1 0 0 0 0 0 0\r\n"
			+ "1 0 0 0 1 1 1 1\r\n"
			+ "6 4 4\r\n"
			+ "1 1 0 0\r\n"
			+ "0 1 0 1\r\n"
			+ "0 0 0 1\r\n"
			+ "1 1 1 1\r\n"
			+ "1 1 0 1\r\n"
			+ "1 0 1 0\r\n"
			+ "6 10 3\r\n"
			+ "0 1 0 0 0 1 0 0 1 1\r\n"
			+ "0 1 1 0 0 1 0 0 1 0\r\n"
			+ "0 1 0 0 1 0 1 1 1 1\r\n"
			+ "0 0 0 0 0 1 1 1 1 0\r\n"
			+ "0 1 0 0 1 1 1 1 1 1\r\n"
			+ "1 0 0 0 1 1 0 0 1 1\r\n"
			+ "6 6 5\r\n"
			+ "0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0\r\n"
			+ "0 0 0 0 0 0\r\n"
			+ "6 6 4\r\n"
			+ "1 1 1 1 1 1\r\n"
			+ "0 0 0 0 0 1\r\n"
			+ "0 1 1 1 0 1\r\n"
			+ "0 1 0 1 0 1\r\n"
			+ "0 1 0 0 0 1\r\n"
			+ "0 1 1 1 1 1\r\n"
			+ "8 15 3\r\n"
			+ "0 1 1 0 0 1 1 0 1 1 0 0 0 0 0\r\n"
			+ "1 0 0 0 1 1 0 0 0 0 0 1 0 1 1\r\n"
			+ "1 1 0 1 0 1 0 1 0 1 0 1 0 0 0\r\n"
			+ "0 1 1 1 0 0 1 0 0 0 0 1 0 0 0\r\n"
			+ "0 0 0 0 0 0 1 0 0 0 1 1 0 0 1\r\n"
			+ "1 0 1 0 0 1 0 1 1 1 1 0 1 1 1\r\n"
			+ "0 0 0 0 0 1 1 1 0 0 0 0 0 1 0\r\n"
			+ "0 0 1 0 1 1 0 1 1 0 0 0 1 0 0\r\n"
			+ "10 20 4\r\n"
			+ "1 0 1 1 1 1 1 1 1 1 0 0 1 1 1 0 1 1 0 1\r\n"
			+ "1 1 0 1 1 1 0 0 1 0 0 0 1 1 1 1 0 0 1 0\r\n"
			+ "1 1 0 1 1 0 0 0 1 1 1 1 1 0 0 1 1 0 1 0\r\n"
			+ "0 0 0 1 1 0 0 0 0 1 0 0 1 0 1 1 1 0 1 0\r\n"
			+ "0 1 1 0 1 0 1 0 1 0 0 1 0 0 0 0 1 1 1 1\r\n"
			+ "1 0 1 0 1 0 1 1 0 0 0 0 1 1 1 0 0 0 0 0\r\n"
			+ "0 1 0 0 1 1 0 0 0 0 0 1 1 0 0 1 1 0 1 1\r\n"
			+ "1 0 0 0 0 1 0 1 1 0 1 1 0 1 0 0 1 1 1 0\r\n"
			+ "0 1 1 0 0 1 0 1 0 0 0 0 0 0 0 1 1 1 0 1\r\n"
			+ "0 0 0 0 0 0 1 1 0 0 1 1 0 0 0 0 0 0 1 0\r\n"
			+ "13 20 5\r\n"
			+ "1 1 0 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 0 0\r\n"
			+ "1 1 1 1 0 1 0 1 0 0 0 0 1 0 0 0 0 1 0 0\r\n"
			+ "1 0 1 0 1 1 0 1 0 1 1 0 0 0 0 1 1 0 1 0\r\n"
			+ "0 0 1 1 0 1 1 0 1 0 0 1 1 0 0 0 1 1 1 1\r\n"
			+ "0 0 1 0 0 1 0 0 1 0 0 0 0 1 0 0 0 0 1 1\r\n"
			+ "0 0 1 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 0 1\r\n"
			+ "0 0 0 1 0 0 0 0 0 0 1 1 0 0 0 1 0 0 1 0\r\n"
			+ "1 1 1 0 0 0 1 0 0 1 1 1 0 1 0 1 0 0 1 1\r\n"
			+ "0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 1 0 0 1\r\n"
			+ "0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1\r\n"
			+ "0 1 0 0 1 1 0 0 1 0 0 0 0 1 0 1 0 0 1 0\r\n"
			+ "0 0 1 1 0 0 1 0 0 0 1 0 1 1 0 1 1 1 0 0\r\n"
			+ "0 0 0 1 0 0 1 0 0 0 1 0 1 1 0 0 1 0 1 0\r\n"
			+ "";
}
