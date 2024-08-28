package 수업;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 퀵정렬01_호어파티션 {
	static int[] arr = {5,1,2,3,6,4,7,8,9};
	static int N = arr.length; //배열의 길이 
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		quickSort(0, N-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int left, int right) {
		if(left<right) {
			int pivot = partition(left, right);
			quickSort(left,pivot-1);
			quickSort(pivot+1,right);
		}
	}
	
	//반환값은 피봇의 위치
	private static int partition(int left, int right) {
		int pivot = arr[left];
		
		int L = left +1, R = right;
		
		while( L<=R) {
			//L: pivot보다 큰 값을 찾을 때까지 이동을 하겠다. 
			while(L<=R && arr[L] <= pivot) L++;
			//R: pivot보다 작거나 같은 값을 만날 때까지 이동을 하겠다. 
			while(arr[R] > pivot) R--;
			
			if(L<R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
				System.out.println(Arrays.toString(arr));
			}
			
		}
		
		//교차 후 
		//R의 위치는 사실 피봇이 가야 할 위치이다. 
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		return R; //피봇의 위치
		
	}
}
