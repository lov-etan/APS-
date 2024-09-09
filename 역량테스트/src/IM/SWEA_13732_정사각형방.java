package IM;

import java.util.Scanner;

public class SWEA_13732_정사각형방 {
    
    static int N;
    static char[][] arr;
    static int R, C;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            arr = new char[N][N];
            boolean found = false; // 첫번째 #을 찾았는지 여부.
            R = C = -1;
            
            // 입력 받으면서 #의 위치 찾기
            for(int r=0; r<N; r++) {
                String str = sc.next();
                for(int c=0; c<N; c++) {
                    arr[r][c] = str.charAt(c);
                    if(!found && str.charAt(c) == '#') {
                        R = r;
                        C = c;
                        found = true;
                    }
                }
            }
            
            if(isSquare()) {
                System.out.println("#"+tc+" yes");
            } else {
                System.out.println("#"+tc+" no");
            }

            
        }
    }
    
    
    private static boolean isSquare() {
        // 가로 길이 계산
        int W = 0;
        for(int r=R; r<N; r++) {
            if(arr[r][C] == '#') W++;
            else break;
        }
        
        // 세로 길이 계산
        int H = 0;
        for(int c=C; c<N; c++) {
            if(arr[R][c] == '#') H++;
            else break;
        }
        
        // 가로 != 세로라면 정사각형 아님
        if(W != H) return false;
        
        
        // 만약 처음 첫줄 제외하고 나머지영역 중에 . 있다면 정사각형 아님
        for(int r=R+1; r<R+W; r++) {
            for(int c=C+1; c<C+W; c++) {
                if(arr[r][c] == '.') return false; 
            }
        }
        
        // 만약 정사각형 이외에 #이 있으면 하나가 아님
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if( r >= R && r < R+W && c >= C && c < C+W) continue;
                if(arr[r][c] == '#') return false;
            }
        }
        
        // 모든 조건을 만족해야 정사각형은 하나만 있다.
        return true;
    }
}
