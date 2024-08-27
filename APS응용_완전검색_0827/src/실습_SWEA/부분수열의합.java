package 실습_SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 부분수열의합 {
	static int N;
	static int K;
	static int cnt;
	static int[] numsR;
	static boolean[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //할당할 때는 앞에 int 쓰지 말기.!!!!
			K = sc.nextInt(); 
			cnt = 0;
			
			numsR = new int[N];
			sel = new boolean[N];
			
			for(int j=0; j<N; j++) {
				numsR[j] = sc.nextInt();
			}
			//System.out.println(Arrays.toString(numsR));
			
			powerset(0);
			
			System.out.println("#" + tc + " " + cnt);
		}//테스트케이스 끝 
	}
	
	static void powerset(int i) {
		//기저조건 
		if(i == N) {
			//System.out.println(Arrays.toString(sel));
			int sum = 0;
			for(int l=0; l<N; l++) {
				if(sel[l]) {
					sum += numsR[l];
				}
			}
			//System.out.println(sum);
			
			if(sum == K) {
				cnt++;
			}
			
			return;
		}
		
		//재귀함수 
		sel[i] = true;
		powerset(i+1);
		
		sel[i] = false;
		powerset(i+1);
	}

}
