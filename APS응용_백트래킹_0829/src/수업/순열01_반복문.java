package 수업;

public class 순열01_반복문 {
	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 1, 2, 3 };
		N = nums.length;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) { //이거 없으면 중복순열 
					for (int k = 0; k < N; k++) {
						if (i != k && j != k) {
							System.out.printf("%d %d %d\n", nums[i], nums[j], nums[k]);
						}
					}
				}
			}
		}
	}

}
