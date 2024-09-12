package 실습;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 쉬운거스름돈_DP포기 {
	static int[] coins = {10, 50, 100, 500, 1000, 5000, 10000, 50000};
	static int[] cnts;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			int C = coins.length;
			cnts = new int[C];
			int idx= C-1;
			while(idx >= 0) {
				int Num = N;
				cnts[idx] = Num / coins[idx];
				//System.out.println(coins[idx] + " " + cnts[idx]);
				N = N % coins[idx];
				//System.out.println(coins[idx] + " "+ N);
				idx--;
			}
			
			System.out.println("#" + tc);
			for(int i=C-1; i>=0; i--) {
				System.out.print(cnts[i] + " ");
			}
			System.out.println();
			
		}
	}
}
