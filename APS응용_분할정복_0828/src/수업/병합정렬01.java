package 수업;

import java.util.Arrays;

public class 병합정렬01 {
	static int[] arr = { 7, 5, 13, 2, 79, 12, 35, 42 };
	static int N = arr.length; // 배열의 길이
	static int[] tmp = new int[N];

	public static void main(String[] args) {
		mergeSort(0, N - 1);
		System.out.println(Arrays.toString(arr));
	}

	// left: 구간의 시작 위치
	// right: 구간의 끝
	static void mergeSort(int left, int right) {

//밑에거랑 같은 말 		
//	if(left >= right) return; //같거나 교차되면 안되므로 
//		int mid = (left+right)/2;
//		mergeSort(left, mid);
//		mergeSort(mid+1, right); 

		if (left < right) { // 아직 내가 할게 있음
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	// left-시작구간, right-끝 구간, mid-왼쪽 끝
	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽구간의 시작 포인트
		int R = mid + 1; // 오른쪽 구간의 시작 포인트

		int idx = left; // tmp 배열의 인덱스

		while (L <= mid && R <= right) { // 조건의 의미는? 왼쪽 구간이든 오른쪽 구간이든 끝에 도달하지 않았다.
			if (arr[L] <= arr[R]) {
				tmp[idx] = arr[L]; // 작은 애가 tmp 첫 칸에 간다.
				idx++;
				L++;
			} else {
				tmp[idx++] = arr[R++];
			}

		}

//		// 남은 애들 왼쪽, 오른쪽 털기~~
//		// 왼쪽 구간의 값이 남았어!
//		if (L <= mid) {
//			for (int i = L; i <= mid; L++) {
//				tmp[idx++] = arr[i];
//			}
//		}
//		// 오른쪽 구간의 값이 남았어
//		else {
//			for (int i = R; i <= right; i++) {
//				tmp[idx++] = arr[i];
//			}
//		}

		// 왼쪽구간의 값이 남았어!
		if (L <= mid) {
			for (int i = L; i <= mid; i++)
				tmp[idx++] = arr[i];
		}
		// 오른쪽구간의 값이 남았어
		else {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}

		// 원본배열에 반영하자
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}

}
