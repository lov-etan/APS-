package 수업;

import java.util.Arrays;

public class 순열03_방문체크 {
	static int[] nums;
	static int N;
	//추가적인 공간 필요 
	static boolean[] visited;
	static int[] result; //난 이거 sel로 했었음 
	
	
	public static void main(String[] args) {
		nums = new int[] { 1, 2, 3 };
		N = nums.length;
		result = new int[N];
		visited = new boolean[N];
		
		perm(0);
	}
	
	//결과 배열에 저장할 위치 
	static void perm(int Sidx) {
		//기저조건
		if(Sidx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		//재귀부분
		for(int pick = 0; pick< N; pick++) {
			//사용하지 않은 원소를 가지고 만들어야 해!
			//1. 사용했으면 넘어가 continue
			//2. 사용하지 않았다면 if(){요기작성}
			
			if(visited[pick])  // 1번 방식
				continue; 
			result[Sidx] = nums[pick];
			visited[pick] = true; //해당 i번째 원소를 사용했습니다. 
			perm(Sidx+1); //다음 자리 판단
			visited[pick] = false; //result는 덮어버리니까 굳이 초기화 할 필요 없음 
		}
		
	}

}
