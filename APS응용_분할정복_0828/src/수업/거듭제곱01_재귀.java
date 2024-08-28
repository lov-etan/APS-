package 수업;

public class 거듭제곱01_재귀 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;

		System.out.println(pow(C, N));
		System.out.println(pow2(C, N));
	}
	
	//땡! 이러면 그냥 두번 제곱하는게 됨
	static int pow(int C, int N) {
		//기저조건
		if(N ==1) return C;
		//재귀부분: 짝수인 경우 / 홀수인 경우
		if(N%2 == 0) {
			return pow(C, N/2)*pow(C, N/2);
		} else {
			return pow(C, (N-1)/2)*pow(C,(N-1)/2)*C;
		}
	}
	
	static int pow2(int C, int N) {
		//기저조건
		if(N ==1) return C; //10반 문종하: N이 0 이 들어올 경우 처리하지 못한다 - 문제 조건에 따라 기저 조건 달라질 것 
		//재귀부분: 짝수인 경우 / 홀수인 경우
		if(N%2 == 0) {
			int tmp = pow2(C, N/2);
			return tmp * tmp;
		} else {
			int tmp = pow2(C, (N-1)/2);
			return tmp * tmp * C;
		}
	}
}
