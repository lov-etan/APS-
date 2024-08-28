package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만개의정수정렬 { //병합정렬로 백만 개의 정수 정렬 시작 //오름차순 정렬임!!!
	static int[] A = new int[1000000];
	static int[] tmp = new int[1000000];
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		A = new int[1000000]; //크기가 백만인 배열 생성 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//병합정렬
		mergeSort(0, A.length-1);
		System.out.println(A[500000]);
	}
	
	
	static void mergeSort(int left, int right) {
		if(left<right) { //분할할게 남았다면, 
			int mid = (left+right)/2;
			mergeSort(left,mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
			
		}
	}
	
	static void merge(int left, int mid, int right) {
		int L = left; //왼쪽 구간 시작 포인트 
		int R = mid + 1; //오른쪽 구간 시작 포인트
		
		int idx = left; //작은 값부터 tmp에 놔둘 인덱스 값
		
		//어느 쪽이든 끝에 도달하지 못하고 어느 원소를 가리키고 있다면, 각 그룹 애들 값 비교하면서 더 작은 애부터 tmp에 놓기 시작한다.
		while( L <= mid && R <= right) {
			if(A[L] <= A[R]) { //오름차순이므로 더 큰 값이 tmp의 가장 왼쪽부터 idx를 갖게 된다.
				tmp[idx] = A[L];
				idx++;
				L++; //다음 단계로 넘어가자~
			} 
			else {
				tmp[idx++] = A[R++];
			}
		}
		
		//남은 애들 털어보자 
//		while(L<=mid) {
//			tmp[idx++] = A[L++];
//		}
		
		
		if(L<=mid) { //원래부터 제대로 되어있던 애들이라 그냥 그대로 넣어주면 됨 
			for(int i=L; i<=mid; i++) 
				tmp[idx++] = A[i];
			
		} else {
			for(int i=R; i<=right; i++) 
				tmp[idx++] = A[i];
			
		}
		
		//원본 배열에 반영하자!
		for(int i=left ; i<=right; i++) { 
			A[i] = tmp[i];
		}
		
		
	}
	
	

}
