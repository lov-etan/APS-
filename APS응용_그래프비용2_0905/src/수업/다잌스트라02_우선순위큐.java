package 수업;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 다잌스트라02_우선순위큐 {
    static class Node implements Comparable<Node> {
        int V, W; // V: 정점 번호, W: 해당 정점까지의 가중치

        public Node(int v, int w) {
            V = v;
            W = w;
        }

        @Override
        public int compareTo(Node o) {
            // 우선순위 큐에서 가중치가 작은 순서대로 정렬
            return Integer.compare(this.W, o.W);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static List<Node>[] adjList; // 인접 리스트
    static int[] dist; // 최단 거리 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        V = sc.nextInt(); // 정점의 수
        E = sc.nextInt(); // 간선의 수

        adjList = new ArrayList[V]; // 정점 개수만큼 인접 리스트 생성

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        dist = new int[V]; // 최단 거리 배열 초기화
        Arrays.fill(dist, INF); // 거리 초기값을 무한대로 설정

        // 간선 정보 입력 및 인접 리스트 구성
        for (int i = 0; i < E; i++) {
            int A = sc.nextInt(); // 시작 정점
            int B = sc.nextInt(); // 도착 정점
            int W = sc.nextInt(); // 가중치
            adjList[A].add(new Node(B, W)); // 방향 그래프이므로 한 방향만 추가
        }

        // 다익스트라 알고리즘 수행 (시작 정점을 0으로 설정)
        dijkstra(0);

        // 각 정점까지의 최단 거리 출력
        System.out.println(Arrays.toString(dist));
    }

    static void dijkstra(int start) {
        // 방문 여부 확인 배열
        boolean[] visited = new boolean[V];

        // 시작 정점의 거리 초기화
        dist[start] = 0;

        // 우선순위 큐 사용 (가중치가 작은 순서대로 정렬)
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0)); // 시작 정점을 큐에 추가

        // 우선순위 큐가 비어있지 않을 때까지 반복
        while (!pq.isEmpty()) {
            // 가장 가중치가 작은 정점을 선택
            Node current = pq.poll();
            int currV = current.V; // 현재 정점
            int currW = current.W; // 현재 정점까지의 가중치

            // 이미 방문한 정점은 무시
            if (visited[currV]) continue;

            // 현재 정점을 방문 처리
            visited[currV] = true;

            // 현재 정점에서 연결된 다른 정점들 확인
            for (Node neighbor : adjList[currV]) {
                int nextV = neighbor.V; // 다음 정점
                int weight = neighbor.W; // 현재 정점에서 다음 정점까지의 가중치

                // 방문하지 않은 정점이고, 최단 거리가 갱신 가능하면 갱신
                if (!visited[nextV] && dist[nextV] > currW + weight) {
                    dist[nextV] = currW + weight; // 최단 거리 갱신
                    pq.add(new Node(nextV, dist[nextV])); // 갱신된 정점을 우선순위 큐에 추가
                }
            }
        }
    }

    static String input = "6 11\r\n"
            + "0 1 4\r\n"
            + "0 2 2\r\n"
            + "0 5 25\r\n"
            + "1 3 8\r\n"
            + "1 4 7\r\n"
            + "2 1 1\r\n"
            + "2 4 4\r\n"
            + "3 0 3\r\n"
            + "3 5 6\r\n"
            + "4 3 5\r\n"
            + "4 5 12\r\n"
            + "";
}
