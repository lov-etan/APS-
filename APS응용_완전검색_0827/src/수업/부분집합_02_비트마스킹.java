package 수업;

import java.util.Arrays;

public class 부분집합_02_비트마스킹 {
	static String[] 재료 = {"단무지","햄","오이","시금치"};
	static int N = 4; //재료의 수
	static int[] sel = new int[N]; //해당 인덱스의 재료를 사용했는지의 유무를 저장하는 배열
	
	public static void main(String[] args) {
		
		//2**N 만큼 반복한다.
		for(int i=0; i<(1<<N); i++) { //i가 하나의 김밥 종류이다. [0,0,0,1] 단무지
			//재료 확인 for문 필요하다.
			String tmp = "";
			for(int j=0; j<N; j++) {//j는 재료의 인덱스 
				//&연산하려면, 해당 재료가 있는지 없는지 알려면 다른 애들은 다 0이고 해당 재료만 1이어야 한다. 
				if((i & (1<<j)) >0) { //100이면 4이므로 ==1 이라고 쓰면 안됨. 
					//해당 재료가 있어요~~
					tmp += 재료[j];
				}
			}//재료 확인 끝
			System.out.println(tmp);
		}
		
	}

}



