import java.util.*;
import java.io.*;

public class Main {

	private static int N, M;
	private static ArrayList<Node>[] nodeList;
	private static int[] dist;						// 최단거리를 저장할 배열
	private static boolean[] visited;				// 방문 여부 확인하는 배열
	
	private static class Node implements Comparable<Node>{
		
		int end, weight;
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        nodeList = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i = 1; i <= N; i++) {
        	nodeList[i] = new ArrayList<>();
        }
        
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int node1 = Integer.parseInt(st.nextToken());
        	int node2 = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	nodeList[node1].add(new Node(node2, weight));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        System.out.println(dijkstra(start, end));
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