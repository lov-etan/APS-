package A;

import java.util.Scanner;

public class 수영장 {
	static int[] tickets;
	static int[] plans;
	static int minCost;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			tickets = new int[4];
			for(int i=0; i<4; i++) {
				tickets[i] = sc.nextInt();
			}//요금 받기 완료
			
			plans = new int[12];
			for(int i=0; i<12; i++) {
				plans[i] = sc.nextInt();
			}//12개일 이용 계획 받기 완료
			
			minCost = tickets[3]; //다른 것들이 다 비싸다면 그냥 1년권 사는게 좋음!! //치즈도둑
			
			thinking(0,0);
			
			System.out.println("#" + tc + " " + minCost);
			
		}//tc
		
	}
	
	static void thinking(int month, int costSum) { 
		//기저 파트 
		if(month >= 12) {
			minCost = Math.min(costSum, minCost);
			return;
			
		}
		
		//재귀 파트 
		//1일권 살 때
		thinking(month+1, costSum + tickets[0]*plans[month]);
		
		//1달권 살 때
		thinking(month+1, costSum + tickets[1]);
		
		//3달권 살 때
		thinking(month+3, costSum + tickets[2]);
	}

}
