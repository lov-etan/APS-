package 숙제;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소스패닝트리 {
	static class Edge{
		int A;
		int B;
		int W;
		
		public Edge(int a, int b, int w) {
			this.A= a;
			this.B= b;
			this.W= w;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
		}

		public int getW() {
			return W;
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));
		for(int i=0; i<E; i++) {
			int A= sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			Edge edge = new Edge(A, B, W);
			pq.add(edge);
		}
	}

}
