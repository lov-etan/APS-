package 수업;
public class 이진검색02_재귀 {

	static int[] arr = { 8, 9, 17, 21, 23, 35, 88, 369 };
	static int key = 19;

	public static void main(String[] args) {
		binarySearch(0, arr.length-1);
		
		//Arrays.binarySearch(null, 0);//배열과 key 입력해주면 반환해준다 (배열, 키)
	}

	static boolean binarySearch(int left, int right) {
		//기저조건 
		if(left>right) return false; //교차가 되는 순간 - 못 찾았어 
		
		//재귀부분 
		int mid = (left + right)/2;
		//같다면 
		if(arr[mid] == key) return true;
		//크다면 (중앙값이)
		else if(arr[mid]>key)
			return binarySearch(left, mid-1);
		//작다면 (중앙값이)
		else //(arr[mid]<key)
			return binarySearch(mid+1, right);
	}
}