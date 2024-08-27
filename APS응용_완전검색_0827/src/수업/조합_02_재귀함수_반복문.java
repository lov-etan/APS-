package 수업;

import java.util.Arrays;

public class 조합_02_재귀함수_반복문 {
	static String[] 재료 = {"상추","패티","토마토","치즈"};
	static int N, R; //N:재료의 수, R: 내가 뽑고 싶은 재료의 수
	static String[] sel; //뽑은 재료들을 저장할 배열 
	
	public static void main(String[] args) {
		N = 4;
		R = 2; //4개 중에 2개를 뽑겠다. 
		sel = new String[R];
		
		combination(0,0);
		
	}
	
	//idx: 재료의 인덱스 
	//sidx: 뽑은 재료의 인덱스 
	public static void combination(int idx, int sidx) {
		//기저조건
		if(sidx == R) {
			//모든 재료를 전부 다 뽑았다!
			System.out.println(Arrays.toString(sel));
			return;
		}
		//내가 이미 범위를 정해두고 반복문을 돌릴꺼니 벗어날 걱정을 할 필요가 없다. 
//		if(idx == N) { //어차피 위에서 완벽한 햄버거는 다 걸려 //요기는 이상해 재료 부족한 친구들만 와
//			return; //상 (패,토,치) 다 돌았어 그러면 이제 return~~ 하면서 빼줘야 한다. //어차피 나머지 친구들 재귀함수 밑바닥에 있기 때문에 더 돌게 없어서 쭉쭉 빼주면서 sel[] 앞자리가 바뀐다.
//		}
		
		//재귀부분

		for(int i=idx; i<=N-R+sidx; i++) { //몇 번째 깊이에서 어디까지 끝내면 되겠다. 
			sel[sidx] = 재료[i]; //뽑았어요~
			combination(i+1, sidx+1);
		}
		//위 반복문이 끝나고 더 이상 수행할 것이 없으니 return~
	}

}
