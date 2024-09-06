package 실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Contact {
    static int start;
    static int last;

    static Map<Integer, List<Integer>> map;
    static boolean[] visited;
    static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken()); // 시작 정점

            // 인접 리스트 만들기
            map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                map.computeIfAbsent(A, k -> new ArrayList<>()).add(B);
            }

            // 방문 배열 초기화
            visited = new boolean[101];
            check = 0; // 최대 깊이
            last = 0;  // 최대 깊이에서 가장 큰 정점

            // DFS 호출
            dfs(start, 0);

            System.out.println("#" + tc + " " + last);
        }
    }

    static void dfs(int vertex, int depth) {
    	visited[vertex] = true;

        // 깊이 업데이트
        if (depth > check) {
            check = depth;
            
            //System.out.println(last);
        } else if (depth == check) {
            last = Math.max(vertex, last);
            //System.out.println(last);
        }

        List<Integer> list = map.get(vertex);
        if (list != null) {
            for (int neighbor : list) {
                if (!visited[neighbor]) {
                    dfs(neighbor, depth + 1);
                }
            }
        }
    }
}