package 수업;

import java.util.Arrays;

//사전 순이 아니라면 선택지로 ㄱㅊ 
//원본 자체가 바뀌는 구조 

public class 순열02_swap {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 1, 2, 3 };
		N = nums.length;
		
		perm(0);
	}
	
	//idx: 현재 판단 위치
	static void perm(int idx) {
		//기저조건
		if(idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		//재귀부분
		for(int i=idx; i<N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i,idx); //다음 과정을 위해서 원상 복구 
		}
	}
	
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

}
