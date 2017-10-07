
import java.util.*;

public class Main {
	
	static class Edge {
		int src;
		int dst;
		int weight;
		public Edge(int s,int d,int w) {
			src = s;
			dst = d;
			weight = w;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n,m;
		int dist[];
		int from,to,weight;
		boolean bNCycle = false;
		
		n = input.nextInt();
		m = input.nextInt();
		Vector<Edge> edgeVec = new Vector<Edge>();
		dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
						
		for (int i = 0; i < m; i++) {			
			from = input.nextInt();
			to = input.nextInt();
			weight = input.nextInt();
			edgeVec.add(new Edge(from,to,weight));
		}
		// bellman ford algorithm
		dist[0] = 0;		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				from = edgeVec.elementAt(j).src;
				to = edgeVec.elementAt(j).dst;
				weight = edgeVec.elementAt(j).weight;
				// minimal distance update
				if (dist[from-1] != Integer.MAX_VALUE && dist[from-1] + weight < dist[to-1])
					dist[to-1] = dist[from-1] + weight;
			}
		}
		// negative cycle check
		for (int j = 0; j < m; j++) {
			from = edgeVec.elementAt(j).src;
			to = edgeVec.elementAt(j).dst;
			weight = edgeVec.elementAt(j).weight;
			
			if (dist[from-1] != Integer.MAX_VALUE && dist[from-1] + weight < dist[to-1]) {
				dist[to-1] = -1;
				bNCycle = true;
				break;
			}
		}
		// if negative cycle exists, print -1 
		if (bNCycle == true) System.out.println(-1);
		else {
			for (int i = 1; i < n; i++) {			
				if (dist[i] == Integer.MAX_VALUE) // can't access vertex i
					System.out.println(-1);
				else
					System.out.println(dist[i]);
			}			
		}				
	}
}
