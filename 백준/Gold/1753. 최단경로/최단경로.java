import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E;
	static ArrayList<Node>[] nodeList;
	static int[] dist;
	static boolean[] visited;
	
	private static class Node implements Comparable<Node>{

		int end, weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			
			return this.weight-o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		final int INF = Integer.MAX_VALUE>>2;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[V+1];
		
		for(int i = 1; i <= V; i++) {
			nodeList[i] = new ArrayList<>();
		}
		dist = new int[V+1];
		visited = new boolean[V+1];
		
		Arrays.fill(dist, INF);
		
		int start = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
        	int node2 = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	nodeList[node1].add(new Node(node2, weight));
		}
		
		for(int i = 1; i <= V; i++) {
			if(i==start) System.out.println(0);
			else {
				int k = dijkstra(start, i);
				if(k==INF) System.out.println("INF");
				else {
					System.out.println(k);
				}
			}
		}
		
	}
	
    public static int dijkstra(int start, int end) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.offer(new Node(start, 0));
    	dist[start] = 0;
    	
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		
    		if(!visited[cur.end]) {
    			visited[cur.end] = true;
    			
    			// 최단 거리 갱신
    			for(Node node : nodeList[cur.end]) {
    				if(!visited[node.end] && dist[node.end] > dist[cur.end] + node.weight) {
    					dist[node.end] = dist[cur.end] + node.weight;
    					
    					pq.add(new Node(node.end, dist[node.end]));
    				}
    			}
    		}
    	}
    	
    	return dist[end];
    }

}