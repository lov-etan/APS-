package 수업;

import java.util.Arrays;

public class 순열04_비트마스킹 {
	static int[] nums;
	static int N;
	//추가적인 공간 필요 
//	static boolean[] visited; //비트마스킹으로 0 이면 사용 안한거고~
	static int[] result; //난 이거 sel로 했었음 
	
	
	public static void main(String[] args) {
		nums = new int[] { 1, 2, 3 };
		N = nums.length;
		result = new int[N];
		
		perm(0,0);
	}
	
	//결과 배열에 저장할 위치 
	static void perm(int Sidx, int visited) {
		//기저조건
		//if(visited == (1<<N)-1) return; 이것도 좋아
		if(Sidx == N) { //N개의 비트가 전부 다 1로 가득함 -> return~
			System.out.println(Arrays.toString(result));
			return;
		}
		
		//재귀부분
		for(int pick = 0; pick< N; pick++) {
			
			/*if(visited[pick])  // 내가 지금 그 원소 썼어요~
				continue; */
			if(((visited & (1<<pick)) != 0)) continue;
			
			
			result[Sidx] = nums[pick];
			perm(Sidx +1 , visited | (1<<pick)); //pick번째 원소를 사용하지 않았었고 이제는 사용 할래요
			
		}
		
	}

}
